package com.example.starwarsapi.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WikiService {

    @Autowired
    RestTemplate restTemplate;

    public String getWikiSearch(String search){
        String result = "https://en.wikipedia.org/w/api.php?action=opensearch&search=" + search + "&format=json";
        return  restTemplate.getForObject(result, String.class);
    }
}
