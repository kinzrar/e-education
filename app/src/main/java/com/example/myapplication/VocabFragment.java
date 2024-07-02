package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VocabFragment extends Fragment {

    private static final String BASE_URL = "https://od-api-sandbox.oxforddictionaries.com/api/v2/";
    private static final String APP_ID = "8f4d5294";
    private static final String APP_KEY = "ee1c22653d1ea331aee5004295e5263e";

    private OxfordApiService apiService;

    private TextView wordTitle;
    private TextView wordDefinition;
    private EditText wordInput;
    private Button searchButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vocab, container, false);

        wordTitle = view.findViewById(R.id.wordTitle);
        wordDefinition = view.findViewById(R.id.wordDefinition);
        wordInput = view.findViewById(R.id.wordInput);
        searchButton = view.findViewById(R.id.searchButton);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(OxfordApiService.class);

        searchButton.setOnClickListener(v -> {
            String word = wordInput.getText().toString().trim();
            if (!word.isEmpty()) {
                Call<DictionaryEntry> call = apiService.getDefinition(APP_ID, APP_KEY, word);
                call.enqueue(new Callback<DictionaryEntry>() {
                    @Override
                    public void onResponse(@NonNull Call<DictionaryEntry> call, @NonNull Response<DictionaryEntry> response) {
                        if (response.isSuccessful()) {
                            DictionaryEntry entry = response.body();
                            if (entry != null && !entry.getLexicalEntries().isEmpty()) {
                                String wordTitleText = entry.getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0);
                                String definition = entry.getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0);
                                wordTitle.setText(wordTitleText);
                                wordDefinition.setText(definition);
                            }
                        } else {
                            Log.e("VocabFragment", "Ошибка в ответе: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<DictionaryEntry> call, @NonNull Throwable t) {
                        Log.e("VocabFragment", "Ошибка: " + t.getMessage());
                    }
                });
            }
        });

        return view;
    }
}
