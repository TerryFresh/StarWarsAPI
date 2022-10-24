// Сходить = сделать http запрос правильным методом  (get/post)
// 1. При старте приложения сходить сюда https://swapi.dev/api за данными подсказка как делать https://stackoverflow.com/questions/27405713/running-code-after-spring-boot-starts
// 2. Полученный ответ прикопать (сохранил в памяти/на диске/ в БД/ похуй где)
// ________
// 3. Делаешь контроллер: который принимает query параметр - search
// 4. Сделать запрос на https://swapi.dev/api/people/?search= в search подставить строку, полученную в пункте 3
// 5. Проитерироваться по всем ресурсам сохраненным в пункте 2 и сделать аналогичные запросы (как в пункте 4)
// 6. Собрать все ответы в один JSON


package com.example.starwarsapi.controller;

import com.example.starwarsapi.model.Root;
import com.example.starwarsapi.service.SwapiApiResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/")
public class MainController {

    private final String URL = "https://swapi.dev/api/";

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SwapiApiResources swapiApiResources;

//    @GetMapping(value = "/")
//    public Root getFilms() throws JsonProcessingException {
//        return swapiApiResources.getResources();
//    }

    @GetMapping(value = "/")
    public String getFilms(@RequestParam String text) throws JsonProcessingException {

        String json = restTemplate.getForObject(URL, String.class);
        Root root = mapper.readValue(json, Root.class);

        String result = restTemplate.getForObject(root.getPeople() + "?search=" + text, String.class);

        return result;
    }


//    @GetMapping("/")
//    public String getFilms() throws IOException {
//
//        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
//
//        try {
//            // convert JSON string to Map
//            Map<String, String> map = mapper.readValue(response.getBody(), Map.class);
//
//            return new JSONObject(map).toJSONString();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       return null;
//    }


//    @GetMapping("/")
//    public String getFilms() throws JsonProcessingException, MalformedURLException {
//        ResponseEntity<String> response
//                = restTemplate.getForEntity("https://swapi.dev/api/people/", String.class);
//        String json = new ObjectMapper().readValue(URL, String.class);
//
//        return json;
//    }
}
