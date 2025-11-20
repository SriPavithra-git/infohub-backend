package com.infohub.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Object getWeather(String city) {
        try {
            String url = apiUrl +
                    "?q=" + city +
                    "&appid=" + apiKey +
                    "&units=metric";

            return restTemplate.getForObject(url, Object.class);

        } catch (Exception e) {
            return Map.of("error", "Unable to fetch weather for: " + city);
        }
    }
}
