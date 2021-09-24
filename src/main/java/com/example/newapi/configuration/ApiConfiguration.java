package com.example.newapi.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {
    @Bean(name = "productsApi")
    public OpenAPI productsApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Products API")
                        .description("RestFul API developed for mobile application."));
    }
}
