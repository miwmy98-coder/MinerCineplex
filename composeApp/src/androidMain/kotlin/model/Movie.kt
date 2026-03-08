package com.example.minercineplex.model

data class Movie(
    val id: Int,
    val title: String,
    val genre: String,
    val duration: String,
    val rating: Double,
    val overview: String,
    val imageUrl: String,
    val director: String,
    val cast: List<String>,
    val trailerUrl: String
)