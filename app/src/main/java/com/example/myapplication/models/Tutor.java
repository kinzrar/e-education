package com.example.myapplication.models;

import java.io.Serializable;

public class Tutor implements Serializable {
    private String name;
    private String email;
    private String description;
    private String price;
    private double rating;
    private String countryOfBirth;
    private int reviews;
    private int lessons;
    private int experience;
    private String videoUrl;

    public Tutor(String name, String email, String description, String price, double rating, String countryOfBirth, int reviews, int lessons, int experience, String videoUrl) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.countryOfBirth = countryOfBirth;
        this.reviews = reviews;
        this.lessons = lessons;
        this.experience = experience;
        this.videoUrl = videoUrl;
    }

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

    public int getReviews() {
        return reviews;
    }

    public int getLessons() {
        return lessons;
    }

    public int getExperience() {
        return experience;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
