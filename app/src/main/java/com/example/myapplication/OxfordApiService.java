package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface OxfordApiService {
    @GET("entries/en-us/{word}")
    Call<DictionaryEntry> getDefinition(
            @Header("app_id") String app_id,
            @Header("app_key") String app_key,
            @Path("word") String word
    );
}
