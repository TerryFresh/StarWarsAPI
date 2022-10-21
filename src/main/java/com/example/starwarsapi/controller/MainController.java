package com.example.starwarsapi.controller;


import com.example.starwarsapi.config.Communication;
import com.example.starwarsapi.model.Films;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class MainController {

//    @Autowired
//    private FilmsRepo filmsRepo;

    Communication communication;

    @GetMapping("/films")
    public List<Films> getFilms(){

        return communication.getAllFilms();
    }

}
