package com.example.myapplication.network

import com.example.myapplication.model.CountResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CountService {
    @GET("/api.php")
    suspend fun getCount(
        @Query("results") results : String
    ): CountResponse
}