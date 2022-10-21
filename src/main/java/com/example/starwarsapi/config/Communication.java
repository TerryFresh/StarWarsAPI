package com.example.starwarsapi.config;

import com.example.starwarsapi.model.Films;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "https://swapi.dev/api/films/1";

    public List<Films> getAllFilms() {

        ResponseEntity<List<Films>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Films>>() {});

        List<Films> allFilms = responseEntity.getBody();
        return allFilms;
    }

    public Films getFilms(int id) {
        return null;
    }
}
