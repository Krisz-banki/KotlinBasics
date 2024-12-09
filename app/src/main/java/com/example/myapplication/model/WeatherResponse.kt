package com.example.myapplication.model

data class WeatherResponse(
    val main: Main,
    val wind: Wind
)

data class Main(
    val temp: Float,
    val feels_like: Float,
    val humidity: Integer
)
data class Wind(
    val speed: Float
)
