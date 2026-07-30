package com.agrivision.backend.controller;


import com.agrivision.backend.dto.WeatherResponse;
import com.agrivision.backend.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {


    private final WeatherService weatherService;


    @GetMapping
    public WeatherResponse getWeather(
            @RequestParam String city
    ){

        return weatherService.getWeather(city);

    }

}