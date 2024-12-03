package com.example.myapplication.model

data class WeatherResponse(
    val main: Main
)

data class Main(
    val temp: Float,
    val feels_like: Float
)
