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
import com.example.starwarsapi.service.WikiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping("/")
public class MainController {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SwapiApiResources swapiApiResources;

    @Autowired
    WikiService wikiService;

    @GetMapping(value = "/")
    public String getFilms() throws JsonProcessingException {
        return swapiApiResources.getResources();
    }

    @GetMapping(value = "/search", produces = "application/json")
    public HashMap<String, Object> getFilms(@RequestParam String text) throws IOException, ParseException {

        byte[] data = swapiApiResources.getResources().getBytes();
        HashMap<String, String> resourceMap = new HashMap<String, String>();
        resourceMap = mapper.readValue(data, new TypeReference<HashMap<String, String>>() {
        });

        ObjectNode objectNode = null;

        HashMap<String, Object> map = new HashMap<>();

        for (Map.Entry<String, String> entry : resourceMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            JSONObject jsonObject = restTemplate.getForObject(value + "?search=" + text, JSONObject.class);

            assert jsonObject != null;
            if (!jsonObject.containsValue(0)) {

                String json = jsonObject.toJSONString();
                JsonNode jsonNode = mapper.readTree(json);

                ArrayNode arrayNode = (ArrayNode) jsonNode.get("results");
                Iterator<JsonNode> itr = arrayNode.elements();

                ArrayList<Object> arrayList = new ArrayList<>();
                while (itr.hasNext()) {
                    objectNode = (ObjectNode) itr.next();
                    String name = String.valueOf(objectNode.findValue("name"));
                    if (name.equals("null")) {
                        name = String.valueOf(objectNode.findValue("title"));
                    }
                    String wiki = wikiService.getWikiSearch(name);

                    JSONParser parser = new JSONParser();
                    JSONArray jsonArray = (JSONArray) parser.parse(wiki);
                    JSONArray arrayNode1 = (JSONArray) jsonArray.get(3);

                    String result = null;

                    if (arrayNode1.size() > 0) {

                        result = (String) arrayNode1.get(0);
                        //calamari cruiser
                        for (int i = 0; i < arrayNode1.size(); i++) {
                            String fori = (String) arrayNode1.get(i);
                            if (fori.contains("Star_Wars")) {
                                result = fori;
                            }
                        }
                    }
                    objectNode.put("wiki", result);
                    arrayList.add(objectNode);
                }

                map.put(key, arrayList);
            }
        }
        return map;
    }
}
