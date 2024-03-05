package co.com.expertgroup.cat.api.breeds.repository;

import co.com.expertgroup.cat.api.breeds.model.Breed;
import co.com.expertgroup.cat.api.common.CatApiConfigurationParameters;
import co.com.expertgroup.cat.exceptions.InformationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class BreedRepositoryServiceImpl implements BreedRepository{

    @Autowired
    private CatApiConfigurationParameters parameters;

    @Override
    public List<Breed> getBreedsById(String breedId) {
        System.err.println(parameters.toString());
        WebClient client = getWebClient();
        Mono<List<Breed>> response =  client.get()
                .uri("v1/breeds/{breedId}",breedId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(httpStatusCode -> HttpStatus.BAD_REQUEST.equals(httpStatusCode) || HttpStatus.INTERNAL_SERVER_ERROR.equals(httpStatusCode),
                        clientResponse -> Mono.error(new InformationException(("Ocurrio un error al consumir el servicio de The Cat API"))))
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
        return response.block();
    }

    private WebClient getWebClient() {
        return WebClient.builder()
                .baseUrl(parameters.getEndpoint())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("x-api-key",parameters.getKey())
                .filters(exchangeFilterFunctions -> {
                    exchangeFilterFunctions.add(logRequest());
                })
                .build();
    }


    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            String method = clientRequest.method().name();
            String url = clientRequest.url().toString();
            StringBuilder sb = new StringBuilder(String.format("Req %s %s\n",method,url));
            sb.append("Headers:\n");
            clientRequest
                    .headers()
                    .forEach((name, values) -> values.forEach(value -> sb.append(name).append(":").append(value).append('\n')));
            System.err.println(sb.toString());
            return Mono.just(clientRequest);
        });
    }

    @Override
    public List<Breed> getBreedsByName(String breedName) {
        WebClient client = getWebClient();
        Mono<List<Breed>> response =  client.get()
                .uri(uriBuilder -> uriBuilder.path("v1/breeds/search").queryParam("q",breedName).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(httpStatusCode -> HttpStatus.BAD_REQUEST.equals(httpStatusCode) || HttpStatus.INTERNAL_SERVER_ERROR.equals(httpStatusCode),
                        clientResponse -> Mono.error(new InformationException(("Ocurrio un error al consumir el servicio de The Cat API"))))
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
        return response.block();
    }
}
