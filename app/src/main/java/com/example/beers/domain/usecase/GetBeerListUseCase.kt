package com.example.beers.domain.usecase

import com.example.beers.domain.repository.BeerRepository
import javax.inject.Inject

class GetBeerListUseCase @Inject constructor(
    private val repository: BeerRepository
){
    suspend operator fun invoke() = repository.getAllTypesOfBeer()
}