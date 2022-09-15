package com.example.beers.presentation

import android.app.Application
import com.example.beers.di.component.DaggerAppComponent

class BeerApp: Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}