package com.example.beers.domain.repository

import com.example.beers.domain.entity.BeerItem

interface BeerRepository {

   suspend fun getAllTypesOfBeer(): List<BeerItem>
}