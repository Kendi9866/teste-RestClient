package com.example.projetoteste.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    RestClient openWeatherRestClient() {
        return RestClient.builder()
                .baseUrl("https://api.openweathermap.org")
                .build();
    }
}
