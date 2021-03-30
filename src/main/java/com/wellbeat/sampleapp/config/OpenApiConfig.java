package com.wellbeat.sampleapp.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${wellbeat.base.url}")
    private String baseUrl;

    @Bean
    public GroupedOpenApi internalOpenApi() {
        return GroupedOpenApi.builder()
                .group("Internal V1").pathsToMatch("/rest/api/v1/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {


        Components components = new Components();

        return new OpenAPI()
                .addServersItem(new Server().url(baseUrl))
                .components(components);
    }
}
