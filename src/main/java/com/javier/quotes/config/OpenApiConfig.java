package com.javier.quotes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Quote of the Day API")
                        .version("1.0")
                        .description("API REST para gestionar frases motivacionales con endpoint especial para la frase del día")
                        .contact(new Contact()
                                .name("Javier")
                                .email("javier.acevedof@gmail.com")));
    }
}
