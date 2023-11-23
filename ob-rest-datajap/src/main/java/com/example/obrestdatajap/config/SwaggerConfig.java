package com.example.obrestdatajap.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API REST OpenBootcamp, gestor de libros")
                        .version("0.11")
                        .description("App para gestionar un CRUD de libros")
                        .termsOfService("https://github.com/")
                        .license(new License().name("MIT").url("http"))
                );
    }

}
