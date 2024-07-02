package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Инициализация LottieAnimationView
        LottieAnimationView animationView = findViewById(R.id.animation_view);
        animationView.setAnimation(R.raw.loading_animation);
        animationView.playAnimation();

        // Запуск MainActivity после задержки
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 5000); // Задержка 5 секунд
    }
}
