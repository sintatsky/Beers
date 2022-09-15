package com.example.beers.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beers.domain.entity.BeerItem
import com.example.beers.domain.usecase.GetBeerListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class BeersViewModel @Inject constructor(
    private val getAllTypesOfBeerListUseCase: GetBeerListUseCase
) :ViewModel() {

    private val _beerList = MutableLiveData<List<BeerItem>>()
    val beerList: LiveData<List<BeerItem>> = _beerList

    init {
        loadData()
    }

     private fun loadData(){
        viewModelScope.launch {
            val result = getAllTypesOfBeerListUseCase()
            _beerList.value = result
        }
    }

}