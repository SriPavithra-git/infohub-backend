package com.infohub.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ConverterService {

    @Value("${exchange.api.url}")
    private String exchangeApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Object getRates() {
        try {
            Map response = restTemplate.getForObject(exchangeApiUrl, Map.class);
            Map rates = (Map) response.get("rates");

            return Map.of(
                    "USD", rates.get("USD"),
                    "EUR", rates.get("EUR")
            );

        } catch (Exception e) {
            return Map.of("error", "Unable to fetch exchange rates.");
        }
    }
}
