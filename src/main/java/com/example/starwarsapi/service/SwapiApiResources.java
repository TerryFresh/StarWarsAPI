package com.example.starwarsapi.service;


import com.example.starwarsapi.model.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SwapiApiResources {

    private final String URL = "https://swapi.dev/api";

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    RestTemplate restTemplate;

//    @EventListener
    @Bean
    public Root getResources() throws JsonProcessingException {

        String json = restTemplate.getForObject(URL, String.class);
        Root root = mapper.readValue(json, Root.class);

        return root;
    }
}
