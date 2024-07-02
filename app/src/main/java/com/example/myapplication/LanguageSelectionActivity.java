package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.models.Tutor;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import java.util.List;

public class LanguageSelectionActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTutors;
    private TutorAdapter adapter;
    private List<Tutor> tutors;
    private List<Tutor> filteredTutors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors);

        recyclerViewTutors = findViewById(R.id.recyclerViewTutors);
        recyclerViewTutors.setLayoutManager(new LinearLayoutManager(this));

        tutors = new ArrayList<>();
        tutors.add(new Tutor("Jhon Smit", "js@ukrnet.com", "Expert in C++ ", "50 USD/hour", 4.5, "USA", 100, 50, 5, "https://www.youtube.com/watch??v=zvLu9KuR504"));
        tutors.add(new Tutor("Sara Conor", "sc@ukrnet.com", "Expert in C++", "45 USD/hour", 4.7, "USA", 150, 60, 6, "https://www.youtube.com/watch?v=example2"));
        tutors.add(new Tutor("Walter White", "ws@ukrnet.com", "Expert in C#", "55 USD/hour", 4.9, "USA", 120, 55, 7, "https://www.youtube.com/watch?v=example3"));
        tutors.add(new Tutor("Megan Conor", "mc@ukrnet.com", "Expert in C#", "60 USD/hour", 4.8, "USA", 130, 65, 8, "https://www.youtube.com/watch?v=example4"));
        tutors.add(new Tutor("Jhon Williams", "jw@ukrnet.com", "Expert in React", "52 USD/hour", 4.6, "USA", 110, 52, 5, "https://www.youtube.com/watch?v=example5"));
        tutors.add(new Tutor("Emma Miller", "em@ukrnet.com", "Expert in React", "48 USD/hour", 4.5, "USA", 140, 60, 6, "https://www.youtube.com/watch?v=example6"));
        tutors.add(new Tutor("Grace Taylor", "gt@ukrnet.com", "Expert in C", "51 USD/hour", 4.7, "USA", 115, 53, 7, "https://www.youtube.com/watch?v=example7"));
        tutors.add(new Tutor("Zoe Garcia", "zg@ukrnet.com", "Expert in Angular", "49 USD/hour", 4.6, "USA", 125, 58, 6, "https://www.youtube.com/watch?v=example8"));
        tutors.add(new Tutor("Zoe Anderson", "za@ukrnet.com", "Expert in Angular", "47 USD/hour", 4.7, "USA", 135, 60, 7, "https://www.youtube.com/watch?v=example9"));
        tutors.add(new Tutor("Lucas Walker", "lw@ukrnet.com", "Expert in Java", "50 USD/hour", 4.8, "USA", 140, 60, 8, "https://www.youtube.com/watch?v=example10"));
        tutors.add(new Tutor("Owen White", "ow@ukrnet.com", "Expert in Java", "53 USD/hour", 4.7, "USA", 130, 55, 6, "https://www.youtube.com/watch?v=example11"));
        tutors.add(new Tutor("Sophia Walker", "sw@ukrnet.com", "Expert in Kotlin", "51 USD/hour", 4.9, "USA", 120, 55, 5, "https://www.youtube.com/watch?v=example12"));
        tutors.add(new Tutor("Amelia Vicar", "av@ukrnet.com", "Expert in Kotlin", "50 USD/hour", 4.6, "USA", 125, 58, 6, "https://www.youtube.com/watch?v=example13"));
        tutors.add(new Tutor("Daniel Jones", "dj@ukrnet.com", "Expert in Python", "48 USD/hour", 4.7, "USA", 135, 60, 7, "https://www.youtube.com/watch?v=example14"));
        tutors.add(new Tutor("Daniel Miler", "dm@ukrnet.com", "Expert in Python", "49 USD/hour", 4.8, "USA", 130, 55, 8, "https://www.youtube.com/watch?v=example15"));

        filteredTutors = new ArrayList<>(tutors);

        adapter = new TutorAdapter(this, filteredTutors);
        recyclerViewTutors.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterTutors(newText);
                return false;
            }
        });
    }

    private void filterTutors(String query) {
        filteredTutors.clear();
        if (query.isEmpty()) {
            filteredTutors.addAll(tutors);
        } else {
            for (Tutor tutor : tutors) {
                if (tutor.getName().toLowerCase().contains(query.toLowerCase()) ||
                        tutor.getEmail().toLowerCase().contains(query.toLowerCase())) {
                    filteredTutors.add(tutor);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}
