package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.models.LoginRequest;
import com.example.myapplication.models.LoginResponse;
import com.example.myapplication.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        //  найти кнопку "Register" и  ее ID
        Button registerButton = findViewById(R.id.buttonRegister);

        //  обработчик нажатия на кнопку
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем Intent для перехода к активити регистрации
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent); // Открываем активити регистрации
            }
        });

        // Обработчик нажатия на кнопку "Авторизуватися"
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (email.equals("admin") && password.equals("admin")) {
                    // Локальная авторизация
                    Toast.makeText(MainActivity.this, "Локальна авторизація успішна", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    // Авторизация через сервер
                    loginUser(email, password);
                }
            }
        });
    }

    private void loginUser(String email, String passwordHash) {
        Call<LoginResponse> call = RetrofitClient.getApiService().login(email, passwordHash);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null) {
                        String token = loginResponse.getToken();
                        Toast.makeText(MainActivity.this, "Успішна авторизація через сервер", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Помилка в відповіді: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Помилка: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Метод для нажатия на  "Забули пароль?"
    public void onForgotPasswordClick(View view) {
        Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
        startActivity(intent); //  активити восстановления пароля
    }
}
