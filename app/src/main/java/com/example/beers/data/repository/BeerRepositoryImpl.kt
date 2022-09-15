package com.example.beers.data.repository

import com.example.beers.data.mapper.BeerMapper
import com.example.beers.data.network.BeersApi
import com.example.beers.domain.entity.BeerItem
import com.example.beers.domain.repository.BeerRepository
import javax.inject.Inject

class BeerRepositoryImpl @Inject constructor(
    private val api: BeersApi,
    private val beerMapper: BeerMapper
) : BeerRepository {

    override suspend fun getAllTypesOfBeer(): List<BeerItem> {
        return api.getAllBeer().map { beerItemDto ->
            beerMapper.mapFromDtoToEntity(beerItemDto)
        }
    }
}