package com.example.projetoteste.Controller;

import com.example.projetoteste.DTO.WeatherResponseDTO;
import com.example.projetoteste.Service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherResponseDTO consultarApi(@RequestParam double lat,
                                           @RequestParam double lon){

        return weatherService.consultarApi(lat,lon);
    }

}
