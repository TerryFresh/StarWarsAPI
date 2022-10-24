// Сходить = сделать http запрос правильным методом  (get/post)
// 1. При старте приложения сходить сюда https://swapi.dev/api за данными подсказка как делать https://stackoverflow.com/questions/27405713/running-code-after-spring-boot-starts
// 2. Полученный ответ прикопать (сохранил в памяти/на диске/ в БД/ похуй где)
// ________
// 3. Делаешь контроллер: который принимает query параметр - search
// 4. Сделать запрос на https://swapi.dev/api/people/?search= в search подставить строку, полученную в пункте 3
// 5. Проитерироваться по всем ресурсам сохраненным в пункте 2 и сделать аналогичные запросы (как в пункте 4)
// 6. Собрать все ответы в один JSON


package com.example.starwarsapi.controller;


import com.example.starwarsapi.service.SwapiApiResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping("/")
public class MainController {

    private final String URL = "https://swapi.dev/api/";

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SwapiApiResources swapiApiResources;

    @GetMapping(value = "/")
    public String getFilms() throws JsonProcessingException {
        return swapiApiResources.getResources();
    }


    @GetMapping(value = "/search")
    public String getFilms(@RequestParam String text) throws IOException {

        byte[] mapData = swapiApiResources.getResources().getBytes();
        HashMap<String, String> resourceMap = new HashMap<String, String>();
        resourceMap = mapper.readValue(mapData, new TypeReference<HashMap<String, String>>() {
        });

        StringBuilder result = new StringBuilder();

        for(Map.Entry<String, String> entry : resourceMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            result.append(restTemplate.getForObject(value + "?search=" + text, String.class));


        }

        return result.toString();
    }


//    @GetMapping(value = "/search")
//    public HashMap getFilms(@RequestParam String text) throws IOException {
//
//        String json = restTemplate.getForObject(URL, String.class);
//        Root root = mapper.readValue(json, Root.class);
//
//        byte[] mapData = json.getBytes();
//        HashMap<String, String> myMap = new HashMap<String, String>();
//        myMap = mapper.readValue(mapData, new TypeReference<HashMap<String,String>>() {});
//
//        System.out.println("Map using TypeReference: "+myMap.values());
//
//        return myMap;
//    }
}
