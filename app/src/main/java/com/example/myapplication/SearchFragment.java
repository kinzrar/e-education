package com.example.myapplication;

import android.content.DialogInterface;
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

        loadLocalData();

        return view;
    }

    private void loadLocalData() {
        languages = new ArrayList<>();

        List<Tutor> cppTutors = new ArrayList<>();
        cppTutors.add(new Tutor("Jhon Smit", "js@ukrnet.com", "Expert in C++", "50 USD/hour", 4.5, "USA", 100, 50, 5, "https://www.youtube.com/watch?v=example1"));
        cppTutors.add(new Tutor("Sara Conor", "sc@ukrnet.com", "C++ Specialist", "45 USD/hour", 4.2, "Canada", 90, 45, 3, "https://www.youtube.com/watch?v=example2"));
        languages.add(new Language("Tutors C++", cppTutors));

        List<Tutor> csharpTutors = new ArrayList<>();
        csharpTutors.add(new Tutor("Walter White", "ws@ukrnet.com", "Expert in C#", "55 USD/hour", 4.8, "UK", 120, 60, 6, "https://www.youtube.com/watch?v=example3"));
        csharpTutors.add(new Tutor("Megan Conor", "mc@ukrnet.com", "C# Specialist", "50 USD/hour", 4.3, "Australia", 110, 55, 4, "https://www.youtube.com/watch?v=example4"));
        languages.add(new Language("Tutors C#", csharpTutors));

        List<Tutor> reactTutors = new ArrayList<>();
        reactTutors.add(new Tutor("Jhon Williams", "jw@ukrnet.com", "Expert in React", "60 USD/hour", 4.9, "USA", 130, 65, 7, "https://www.youtube.com/watch?v=example5"));
        reactTutors.add(new Tutor("Emma Miller", "em@ukrnet.com", "React Specialist", "55 USD/hour", 4.5, "UK", 120, 60, 5, "https://www.youtube.com/watch?v=example6"));
        languages.add(new Language("Tutors React", reactTutors));

        List<Tutor> cTutors = new ArrayList<>();
        cTutors.add(new Tutor("Grace Taylor", "gt@ukrnet.com", "Expert in C", "40 USD/hour", 4.1, "Germany", 80, 40, 4, "https://www.youtube.com/watch?v=example7"));
        cTutors.add(new Tutor("Emma Miller", "em@ukrnet.com", "C Specialist", "45 USD/hour", 4.3, "France", 90, 45, 5, "https://www.youtube.com/watch?v=example8"));
        languages.add(new Language("Tutors C", cTutors));

        List<Tutor> angularTutors = new ArrayList<>();
        angularTutors.add(new Tutor("Zoe Garcia", "zg@ukrnet.com", "Expert in Angular", "65 USD/hour", 4.7, "Spain", 140, 70, 8, "https://www.youtube.com/watch?v=example9"));
        angularTutors.add(new Tutor("Zoe Anderson", "za@ukrnet.com", "Angular Specialist", "60 USD/hour", 4.6, "Italy", 130, 65, 7, "https://www.youtube.com/watch?v=example10"));
        languages.add(new Language("Tutors Angular", angularTutors));

        List<Tutor> javaTutors = new ArrayList<>();
        javaTutors.add(new Tutor("Lucas Walker", "lw@ukrnet.com", "Expert in Java", "70 USD/hour", 4.9, "USA", 150, 75, 9, "https://www.youtube.com/watch?v=example11"));
        javaTutors.add(new Tutor("Owen White", "ow@ukrnet.com", "Java Specialist", "65 USD/hour", 4.7, "UK", 140, 70, 8, "https://www.youtube.com/watch?v=example12"));
        languages.add(new Language("Tutors Java", javaTutors));

        List<Tutor> kotlinTutors = new ArrayList<>();
        kotlinTutors.add(new Tutor("Sophia Walker", "sw@ukrnet.com", "Expert in Kotlin", "60 USD/hour", 4.6, "USA", 130, 65, 7, "https://www.youtube.com/watch?v=example13"));
        kotlinTutors.add(new Tutor("Amelia Vicar", "av@ukrnet.com", "Kotlin Specialist", "55 USD/hour", 4.5, "Canada", 120, 60, 6, "https://www.youtube.com/watch?v=example14"));
        languages.add(new Language("Tutors Kotlin", kotlinTutors));

        List<Tutor> pythonTutors = new ArrayList<>();
        pythonTutors.add(new Tutor("Daniel Jones", "dj@ukrnet.com", "Expert in Python", "65 USD/hour", 4.8, "UK", 140, 70, 8, "https://www.youtube.com/watch?v=example15"));
        pythonTutors.add(new Tutor("Daniel Miler", "dm@ukrnet.com", "Python Specialist", "60 USD/hour", 4.6, "Australia", 130, 65, 7, "https://www.youtube.com/watch?v=example16"));
        languages.add(new Language("Tutors Python", pythonTutors));
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
                TutorAdapter adapter = new TutorAdapter(getContext(), selectedTutors);
                recyclerViewSelectedTutors.setAdapter(adapter);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
