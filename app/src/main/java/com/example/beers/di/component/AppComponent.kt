package com.example.beers.di.component

import android.app.Application
import com.example.beers.di.modules.DataModule
import com.example.beers.di.modules.NetworkModule
import com.example.beers.di.modules.ViewModelModule
import com.example.beers.presentation.fragment.BeerListFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(fragment: BeerListFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }
}