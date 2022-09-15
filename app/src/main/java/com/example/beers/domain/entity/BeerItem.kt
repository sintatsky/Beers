package com.example.beers.domain.entity

data class BeerItem(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val image_url: String
)