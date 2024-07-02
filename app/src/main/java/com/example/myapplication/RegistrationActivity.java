package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.models.RegisterRequest;
import com.example.myapplication.models.RegisterResponse;
import com.example.myapplication.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextLogin, editTextPassword, editTextRepeatPassword, editTextEmail, editTextRealName;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextLogin = findViewById(R.id.editTextLogin);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRepeatPassword = findViewById(R.id.editTextRepeatPassword);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextRealName = findViewById(R.id.editTextRealName);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(v -> {
            if (validateInputs()) {
                String login = editTextLogin.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String repeatPassword = editTextRepeatPassword.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String realName = editTextRealName.getText().toString().trim();

                registerUser(login, password, repeatPassword, email, realName);
            }
        });
    }
    // Метод для обработки нажатия кнопки "Назад"
    public void goBack(View view) {
        finish();
    }
    private boolean validateInputs() {
        String login = editTextLogin.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String repeatPassword = editTextRepeatPassword.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String realName = editTextRealName.getText().toString().trim();

        if (login.isEmpty() || password.isEmpty() || repeatPassword.isEmpty() || email.isEmpty() || realName.isEmpty()) {
            Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!password.equals(repeatPassword)) {
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void registerUser(String login, String password, String repeatPassword, String email, String realName) {
        RegisterRequest registerRequest = new RegisterRequest(login, password, repeatPassword, email, realName);
        Call<RegisterResponse> call = RetrofitClient.getApiService().registerUser(registerRequest);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RegisterResponse registerResponse = response.body();
                    if (registerResponse.isSuccess()) {
                        String successMessage = registerResponse.getMessage() != null ? registerResponse.getMessage() : "Регистрация успешна";
                        Toast.makeText(RegistrationActivity.this, successMessage, Toast.LENGTH_SHORT).show();
                    } else {
                        String errorMessage = registerResponse.getMessage() != null ? registerResponse.getMessage() : "Неизвестная ошибка регистрации";
                        Toast.makeText(RegistrationActivity.this, "Ошибка регистрации: " + errorMessage, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("RegistrationActivity", "Ошибка регистрации: " + response.code() + " " + response.message());
                    Toast.makeText(RegistrationActivity.this, "Ошибка регистрации: " + response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.e("RegistrationActivity", "Ошибка: " + t.getMessage(), t);
                Toast.makeText(RegistrationActivity.this, "Ошибка: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
