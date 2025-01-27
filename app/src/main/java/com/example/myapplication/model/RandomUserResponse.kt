package com.example.myapplication.model

data class RandomUserResponse(
    val results: List<RUser>
)
data class RUser(
    val name: Name,
    val picture: Picture,
    val location: Location,
    val email: String

)
data class Name(
    val first: String,
    val last: String
)
data class Location(
    val country: String
)
data class Picture(
    val medium: String
)