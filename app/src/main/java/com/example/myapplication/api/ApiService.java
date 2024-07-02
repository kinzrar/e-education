package com.example.myapplication.api;

import com.example.myapplication.models.LoginResponse;
import com.example.myapplication.models.RegisterRequest;
import com.example.myapplication.models.RegisterResponse;
import com.example.myapplication.models.Language;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("Home/Login")
    Call<LoginResponse> login(@Query("email") String email, @Query("passwordHash") String passwordHash);

    @GET("Home/lang")
    Call<List<Language>> getLanguages();

    @POST("Home/RegisterUserJson")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);
}
