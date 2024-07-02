package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.models.Tutor;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class TutorDetailActivity extends AppCompatActivity {

    private TextView textViewTutorName;
    private TextView textViewTutorEmail;
    private TextView textViewTutorDescription;
    private TextView textViewTutorRating;
    private TextView textViewTutorPrice;
    private TextView textViewTutorCountry;
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_detail);

        textViewTutorName = findViewById(R.id.textViewTutorName);
        textViewTutorEmail = findViewById(R.id.textViewTutorEmail);
        textViewTutorDescription = findViewById(R.id.textViewTutorDescription);
        textViewTutorRating = findViewById(R.id.textViewTutorRating);
        textViewTutorPrice = findViewById(R.id.textViewTutorPrice);
        textViewTutorCountry = findViewById(R.id.textViewTutorCountry);
        youTubePlayerView = findViewById(R.id.youtube_player_view);

        Tutor tutor = (Tutor) getIntent().getSerializableExtra("tutor");
        if (tutor != null) {
            textViewTutorName.setText(tutor.getName());
            textViewTutorEmail.setText(tutor.getEmail());
            textViewTutorDescription.setText(tutor.getDescription());
            textViewTutorRating.setText(String.valueOf(tutor.getRating()));
            textViewTutorPrice.setText(tutor.getPrice());
            textViewTutorCountry.setText(tutor.getCountryOfBirth());

            initializeYouTubePlayer(tutor.getVideoUrl());
        } else {
            Toast.makeText(this, "Error loading tutor details", Toast.LENGTH_SHORT).show();
        }
    }

    private void initializeYouTubePlayer(String videoUrl) {
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = videoUrl.split("v=")[1];
                youTubePlayer.cueVideo(videoId, 0);
            }
        });
    }
}
