package com.example.myapplication.models;

import java.io.Serializable;

public class Tutor implements Serializable {
    private String name;
    private String email;
    private String description;
    private String price;
    private double rating;
    private String countryOfBirth;
    private String videoUrl;

    public Tutor(String name, String email, String description, String price, double rating, String countryOfBirth, String videoUrl) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.countryOfBirth = countryOfBirth;
        this.videoUrl = videoUrl;
    }

    // Getters and setters for all fields

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
