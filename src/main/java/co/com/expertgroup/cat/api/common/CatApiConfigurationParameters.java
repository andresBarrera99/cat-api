package co.com.expertgroup.cat.api.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "api")
public class CatApiConfigurationParameters {

    private String endpoint;
    private String key;
}
