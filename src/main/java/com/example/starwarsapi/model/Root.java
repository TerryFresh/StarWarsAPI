package com.example.starwarsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root{

    private String films;

    private String people;

    private String planets;

    private String species;

    private String starships;

    private String vehicles;

    public String getFilms() {
        return films;
    }

    public void setFilms(String films) {
        this.films = films;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPlanets() {
        return planets;
    }

    public void setPlanets(String planets) {
        this.planets = planets;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStarships() {
        return starships;
    }

    public void setStarships(String starships) {
        this.starships = starships;
    }

    public String getVehicles() {
        return vehicles;
    }

    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }
}
