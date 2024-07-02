package com.example.myapplication.models;

import java.io.Serializable;
import java.util.List;

public class Language implements Serializable {
    private String title;
    private List<Tutor> tutors;

    public Language(String title, List<Tutor> tutors) {
        this.title = title;
        this.tutors = tutors;
    }

    public String getTitle() {
        return title;
    }

    public List<Tutor> getTutors() {
        return tutors;
    }

    @Override
    public String toString() {
        return title;
    }
}
