package com.example.starwarsapi.model;


import java.util.List;

public class People{

    //Search Fields
    private String name;

    private String birthYear;

    private String eyeColor;

    private String gender;

    private String hairColor;

    private String height;

    private String mass;

    private String skinColor;

    private String homeworld;

    private List<Films> films;

    private List<Species> species;

    private List<Starships> starships;

    private List<Vehicles> vehicles;

    private String url;

    private String created;

    private String edited;

    public People() {
    }

    public People(String name, String birthYear, String eyeColor, String gender, String hairColor, String height, String mass, String skinColor, String homeworld, List<Films> films, List<Species> species, List<Starships> starships, List<Vehicles> vehicles, String url, String created, String edited) {
        this.name = name;
        this.birthYear = birthYear;
        this.eyeColor = eyeColor;
        this.gender = gender;
        this.hairColor = hairColor;
        this.height = height;
        this.mass = mass;
        this.skinColor = skinColor;
        this.homeworld = homeworld;
        this.films = films;
        this.species = species;
        this.starships = starships;
        this.vehicles = vehicles;
        this.url = url;
        this.created = created;
        this.edited = edited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<Films> getFilms() {
        return films;
    }

    public void setFilms(List<Films> films) {
        this.films = films;
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

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", gender='" + gender + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", skinColor='" + skinColor + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", films=" + films +
                ", species=" + species +
                ", starships=" + starships +
                ", vehicles=" + vehicles +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                '}';
    }
}
