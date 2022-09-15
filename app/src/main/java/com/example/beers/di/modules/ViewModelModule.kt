package com.example.beers.di.modules

import androidx.lifecycle.ViewModel
import com.example.beers.di.annotation.ViewModelKey
import com.example.beers.presentation.viewmodel.BeersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BeersViewModel::class)
    fun bindBeerViewModel(viewModel: BeersViewModel): ViewModel
}