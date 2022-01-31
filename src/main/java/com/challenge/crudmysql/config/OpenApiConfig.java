package com.challenge.crudmysql.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    //http://localhost:8080/swagger-ui/index.html#/

    @Bean
    public OpenAPI config() {
        return new OpenAPI()
                .components(new Components())
                .info(info());
    }

    private Info info() {
        return new Info()
                .title("Products API")
                .version("1.0.0")
                .description("Challenge 18: OpenApi with SpringBoot");
    }

}
