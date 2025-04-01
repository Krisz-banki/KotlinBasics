package com.example.myapplication.network

import com.example.myapplication.model.Beer
import com.example.myapplication.model.BeerResponse
import com.example.myapplication.model.RandomUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerService {
    @GET("beers?")
    suspend fun getBeers(): List<Beer>
}