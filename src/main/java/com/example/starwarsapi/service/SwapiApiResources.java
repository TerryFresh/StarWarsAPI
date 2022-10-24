package com.example.starwarsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SwapiApiResources {

    private final String URL = "https://swapi.dev/api";

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public String getResources() {
        return restTemplate.getForObject(URL, String.class);
    }
}
