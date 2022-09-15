package com.example.beers.di.modules

import androidx.room.Room
import com.example.beers.data.repository.BeerRepositoryImpl
import com.example.beers.domain.repository.BeerRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DataModule {
    @Binds
    fun bindBeerRepository(impl: BeerRepositoryImpl): BeerRepository

}