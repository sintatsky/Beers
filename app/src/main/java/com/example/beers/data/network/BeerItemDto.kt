package com.example.beers.data.network

data class BeerItemDto(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val image_url: String
)