package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import com.example.myapplication.models.Language;
import com.example.myapplication.models.Tutor;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private Button buttonSelectLanguage;
    private RecyclerView recyclerViewSelectedTutors;
    private List<Language> languages = new ArrayList<>();
    private List<Tutor> selectedTutors = new ArrayList<>();
    private TutorAdapter tutorAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        buttonSelectLanguage = view.findViewById(R.id.button_select_language);
        recyclerViewSelectedTutors = view.findViewById(R.id.recyclerViewSelectedTutors);
        recyclerViewSelectedTutors.setLayoutManager(new LinearLayoutManager(getContext()));

        buttonSelectLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLanguageSelectionDialog();
            }
        });

        // Инициализация локальных данных
        initializeLocalData();

        return view;
    }

    private void initializeLocalData() {
        // Добавление всех преподавателей локально
        List<Tutor> tutors = new ArrayList<>();
        tutors.add(new Tutor("John Smith", "js@ukrnet.com", "Expert in C++", 4.5, "50 USD/hour", "USA", "https://www.youtube.com/watch?v=video1"));
        tutors.add(new Tutor("Sara Conor", "sc@ukrnet.com", "Expert in C++", 4.7, "45 USD/hour", "USA", "https://www.youtube.com/watch?v=video2"));
        tutors.add(new Tutor("Walter White", "ww@ukrnet.com", "Expert in C#", 4.9, "55 USD/hour", "USA", "https://www.youtube.com/watch?v=video3"));
        tutors.add(new Tutor("Megan Conor", "mc@ukrnet.com", "Expert in C#", 4.8, "50 USD/hour", "USA", "https://www.youtube.com/watch?v=video4"));
        tutors.add(new Tutor("John Williams", "jw@ukrnet.com", "Expert in React", 4.9, "60 USD/hour", "USA", "https://www.youtube.com/watch?v=video5"));
        tutors.add(new Tutor("Emma Miller", "em@ukrnet.com", "Expert in React", 4.5, "55 USD/hour", "UK", "https://www.youtube.com/watch?v=video6"));
        tutors.add(new Tutor("Grace Taylor", "gt@ukrnet.com", "Expert in C", 4.6, "51 USD/hour", "USA", "https://www.youtube.com/watch?v=video7"));
        tutors.add(new Tutor("Zoe Garcia", "zg@ukrnet.com", "Expert in Angular", 4.6, "49 USD/hour", "USA", "https://www.youtube.com/watch?v=video8"));
        tutors.add(new Tutor("Zoe Anderson", "za@ukrnet.com", "Expert in Angular", 4.7, "47 USD/hour", "USA", "https://www.youtube.com/watch?v=video9"));
        tutors.add(new Tutor("Owen White", "ow@ukrnet.com", "Expert in Java", 4.8, "53 USD/hour", "USA", "https://www.youtube.com/watch?v=video10"));
        tutors.add(new Tutor("Sophia Walker", "sw@ukrnet.com", "Expert in Kotlin", 4.9, "51 USD/hour", "USA", "https://www.youtube.com/watch?v=video11"));
        tutors.add(new Tutor("Amelia Vicar", "av@ukrnet.com", "Expert in Kotlin", 4.8, "50 USD/hour", "USA", "https://www.youtube.com/watch?v=video12"));
        tutors.add(new Tutor("Daniel Jones", "dj@ukrnet.com", "Expert in Python", 4.8, "48 USD/hour", "UK", "https://www.youtube.com/watch?v=video13"));
        tutors.add(new Tutor("Daniel Miler", "dm@ukrnet.com", "Expert in Python", 4.8, "49 USD/hour", "Australia", "https://www.youtube.com/watch?v=video14"));

        Language cPlusPlusLanguage = new Language("C++", tutors);
        languages.add(cPlusPlusLanguage);

        // Установка адаптера
        tutorAdapter = new TutorAdapter(selectedTutors, new TutorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Tutor tutor) {
                Intent intent = new Intent(getActivity(), TutorDetailActivity.class);
                intent.putExtra("tutor", tutor);
                startActivity(intent);
            }
        });
        recyclerViewSelectedTutors.setAdapter(tutorAdapter);
    }

    private void showLanguageSelectionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Выберите язык");

        String[] languageTitles = new String[languages.size()];
        for (int i = 0; i < languages.size(); i++) {
            languageTitles[i] = languages.get(i).getTitle();
        }

        builder.setItems(languageTitles, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Language selectedLanguage = languages.get(which);
                selectedTutors.clear();
                selectedTutors.addAll(selectedLanguage.getTutors());
                tutorAdapter.notifyDataSetChanged();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
