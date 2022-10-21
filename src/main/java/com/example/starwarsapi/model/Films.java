package com.example.starwarsapi.model;


import java.util.List;

public class Films{

    //Search Fields:
    private String title;

    private int episodeId;

    private String openingCrawl;

    private String director;

    private String producer;

    private String releaseDate;

    private List<Species> species;

    private List<Starships> starships;

    private List<Vehicles> vehicles;

    private List<People> characters;

    private List<Planets> planets;

    private String url;

    private String created;

    private String edited;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Species> getSpecies() {
        return species;
    }

    public void setSpecies(List<Species> species) {
        this.species = species;
    }

    public List<Starships> getStarships() {
        return starships;
    }

    public void setStarships(List<Starships> starships) {
        this.starships = starships;
    }

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    public List<People> getCharacters() {
        return characters;
    }

    public void setCharacters(List<People> characters) {
        this.characters = characters;
    }

    public List<Planets> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planets> planets) {
        this.planets = planets;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }
}
