package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.models.Tutor;

public class TutorDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_detail);

        Tutor tutor = (Tutor) getIntent().getSerializableExtra("tutor");

        WebView webViewVideo = findViewById(R.id.webViewVideo);
        ImageView imageViewTutorPhoto = findViewById(R.id.imageViewTutorPhoto);
        TextView textViewTutorName = findViewById(R.id.textViewTutorName);
        TextView textViewTutorEmail = findViewById(R.id.textViewTutorEmail);
        TextView textViewTutorCountry = findViewById(R.id.textViewTutorCountry);
        TextView textViewTutorDescription = findViewById(R.id.textViewTutorDescription);
        TextView textViewTutorRating = findViewById(R.id.textViewTutorRating);
        TextView textViewTutorPrice = findViewById(R.id.textViewTutorPrice);
        TextView textViewTutorReviews = findViewById(R.id.textViewTutorReviews);
        TextView textViewTutorLessons = findViewById(R.id.textViewTutorLessons);
        TextView textViewTutorExperience = findViewById(R.id.textViewTutorExperience);

        textViewTutorName.setText(tutor.getName());
        textViewTutorEmail.setText(tutor.getEmail());
        textViewTutorCountry.setText(tutor.getCountryOfBirth());
        textViewTutorDescription.setText(tutor.getDescription());
        textViewTutorRating.setText(String.valueOf(tutor.getRating()));
        textViewTutorPrice.setText(tutor.getPrice());
        textViewTutorReviews.setText(String.valueOf(tutor.getReviews()));
        textViewTutorLessons.setText(String.valueOf(tutor.getLessons()));
        textViewTutorExperience.setText(String.valueOf(tutor.getExperience()));

        WebSettings webSettings = webViewVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewVideo.setWebViewClient(new WebViewClient());
        webViewVideo.loadUrl(tutor.getVideoUrl());
    }
}
