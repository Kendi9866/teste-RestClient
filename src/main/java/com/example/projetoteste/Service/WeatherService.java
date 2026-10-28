package com.example.projetoteste.Service;

import com.example.projetoteste.DTO.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private final RestClient restClient;

    public WeatherService(RestClient openWeatherRestClient) {
        this.restClient = openWeatherRestClient;
    }

    @Value("${openweather.api-key}")
    private String apiKey;


    public WeatherResponseDTO consultarApi(double lat, double lon){
        return restClient.get().uri(uriBuilder ->
                                 uriBuilder
                                .path("/data/2.5/weather")
                                .queryParam("lat", lat)
                                .queryParam("lon", lon)
                                .queryParam("appid", apiKey)
                                .build())
                .retrieve()
                .body(WeatherResponseDTO.class);
    }
}
