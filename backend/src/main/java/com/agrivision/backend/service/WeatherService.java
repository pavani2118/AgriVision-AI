package com.agrivision.backend.service;

import com.agrivision.backend.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final RestClient restClient;


    @Value("${weather.api.key}")
    private String apiKey;


    @Value("${weather.api.url}")
    private String apiUrl;


    public WeatherResponse getWeather(String city) {


        Map<String, Object> response = restClient.get()
                .uri(apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric")
                .retrieve()
                .body(Map.class);


        WeatherResponse weather = new WeatherResponse();


        weather.setCity(city);


        Map<String, Object> main =
                (Map<String, Object>) response.get("main");


        weather.setTemperature(
                Double.parseDouble(main.get("temp").toString())
        );


        weather.setHumidity(
                Integer.parseInt(main.get("humidity").toString())
        );


        var weatherList =
                (java.util.List<Map<String,Object>>) response.get("weather");


        weather.setDescription(
                weatherList.get(0).get("description").toString()
        );


        return weather;
    }
}