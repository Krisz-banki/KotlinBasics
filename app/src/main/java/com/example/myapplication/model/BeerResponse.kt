package com.example.myapplication.model

data class BeerResponse(
    val results: List<Beer>
)

data class Beer(
    val name: String,
    val description: String,
    val contributed_by: String
)
