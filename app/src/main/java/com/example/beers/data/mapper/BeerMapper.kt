package com.example.beers.data.mapper

import com.example.beers.data.network.BeerItemDto
import com.example.beers.domain.entity.BeerItem
import javax.inject.Inject

class BeerMapper @Inject constructor() {

    fun mapFromDtoToEntity(dto: BeerItemDto) = BeerItem(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        image_url = dto.image_url,
        tagline = dto.tagline
    )
}