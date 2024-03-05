package co.com.expertgroup.cat.api.breeds.repository;

import co.com.expertgroup.cat.api.breeds.model.Breed;
import co.com.expertgroup.cat.api.common.CatApiConfigurationParameters;
import co.com.expertgroup.cat.exceptions.InformationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BreedRepositoryServiceImplTest {


    @InjectMocks
    private BreedRepositoryServiceImpl repositoryService;

    @Mock
    private CatApiConfigurationParameters parameters;

    @Test
    void getBreedsByIdTest_whenBreedIdIsNull() {
        when(parameters.getEndpoint()).thenReturn("https://api.thecatapi.com/");
        when(parameters.getKey()).thenReturn("");
        repositoryService.getBreedsById(null);
    }

    @Test
    void getBreedsByIdTest_whenBreedIdIsNotNull() {
        when(parameters.getEndpoint()).thenReturn("https://api.thecatapi.com/");
        when(parameters.getKey()).thenReturn("");
        InformationException ex = Assertions.assertThrows(InformationException.class,() -> repositoryService.getBreedsById("2"));
        assertEquals("Ocurrio un error al consumir el servicio de The Cat API",ex.getMessage());
    }

    @Test
    void getBreedsByNameTest() {
        when(parameters.getEndpoint()).thenReturn("https://api.thecatapi.com/");
        when(parameters.getKey()).thenReturn("");
        List< Breed> response = repositoryService.getBreedsByName("American");
        Assertions.assertFalse(response.isEmpty());

    }
}