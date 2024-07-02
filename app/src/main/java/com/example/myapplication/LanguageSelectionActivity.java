package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.models.Tutor;
import java.util.ArrayList;
import java.util.List;

public class LanguageSelectionActivity extends AppCompatActivity {

    private RecyclerView tutorsRecyclerView;
    private TutorAdapter tutorAdapter;
    private List<Tutor> tutors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        tutorsRecyclerView = findViewById(R.id.tutorsRecyclerView);
        tutorsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tutors = new ArrayList<>();
        tutors.add(new Tutor("Jhon Smit", "js@ukrnet.com", "Expert in C++", "50 USD/hour", 4.5, "USA", "https://www.youtube.com/watch?v=example1"));
        tutors.add(new Tutor("Sara Conor", "sc@ukrnet.com", "Expert in C++", "45 USD/hour", 4.7, "USA", "https://www.youtube.com/watch?v=example2"));
        tutors.add(new Tutor("Walter White", "ws@ukrnet.com", "Expert in C#", "55 USD/hour", 4.9, "USA", "https://www.youtube.com/watch?v=example3"));
        tutors.add(new Tutor("Megan Conor", "mc@ukrnet.com", "Expert in React", "48 USD/hour", 4.6, "USA", "https://www.youtube.com/watch?v=example4"));
        tutors.add(new Tutor("Jhon Williams", "jw@ukrnet.com", "Expert in React", "60 USD/hour", 4.8, "USA", "https://www.youtube.com/watch?v=example5"));
        tutors.add(new Tutor("Emma Miller", "em@ukrnet.com", "React Specialist", "55 USD/hour", 4.5, "UK", "https://www.youtube.com/watch?v=example6"));
        tutors.add(new Tutor("Grace Taylor", "gt@ukrnet.com", "Expert in C", "50 USD/hour", 4.7, "USA", "https://www.youtube.com/watch?v=example7"));
        tutors.add(new Tutor("Zoe Garcia", "zg@ukrnet.com", "Expert in Angular", "49 USD/hour", 4.7, "USA", "https://www.youtube.com/watch?v=example8"));
        tutors.add(new Tutor("Zoe Anderson", "za@ukrnet.com", "Expert in Angular", "47 USD/hour", 4.6, "USA", "https://www.youtube.com/watch?v=example9"));
        tutors.add(new Tutor("Owen White", "ow@ukrnet.com", "Expert in Java", "50 USD/hour", 4.8, "USA", "https://www.youtube.com/watch?v=example10"));
        tutors.add(new Tutor("Sophia Walker", "sw@ukrnet.com", "Expert in Java", "53 USD/hour", 4.9, "USA", "https://www.youtube.com/watch?v=example11"));
        tutors.add(new Tutor("Amelia Vican", "av@ukrnet.com", "Expert in Kotlin", "51 USD/hour", 4.9, "USA", "https://www.youtube.com/watch?v=example12"));
        tutors.add(new Tutor("Daniel Jones", "dj@ukrnet.com", "Expert in Python", "48 USD/hour", 4.8, "USA", "https://www.youtube.com/watch?v=example13"));
        tutors.add(new Tutor("Daniel Miler", "dm@ukrnet.com", "Python Specialist", "49 USD/hour", 4.8, "USA", "https://www.youtube.com/watch?v=example14"));

        tutorAdapter = new TutorAdapter(this, tutors);
        tutorsRecyclerView.setAdapter(tutorAdapter);
    }
}
