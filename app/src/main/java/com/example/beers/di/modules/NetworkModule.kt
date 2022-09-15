package com.example.beers.di.modules

import com.example.beers.data.network.BeersApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideJokeApi(): BeersApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(BeersApi::class.java)
    }

    companion object {
        private const val BASE_URL = "https://api.punkapi.com/"
    }
}