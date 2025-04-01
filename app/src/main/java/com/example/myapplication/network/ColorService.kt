package com.example.myapplication.network;

import com.example.myapplication.model.ColorResponse;

import retrofit2.Call;
import retrofit2.http.GET;

interface ColorService {
    @GET("api/unknown")
    fun getColors(): Call<ColorResponse>
}

