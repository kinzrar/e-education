package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.models.Tutor;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import java.util.List;

public class TutorsActivity extends AppCompatActivity {

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

        tutors = (List<Tutor>) getIntent().getSerializableExtra("tutors");
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
