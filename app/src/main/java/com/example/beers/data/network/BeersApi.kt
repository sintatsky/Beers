package com.example.beers.data.network

import com.example.beers.domain.entity.BeerItem
import retrofit2.http.GET

interface BeersApi {

    @GET("v2/beers")
    suspend fun getAllBeer(): List<BeerItemDto>
}