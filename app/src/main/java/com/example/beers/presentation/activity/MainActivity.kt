package com.example.beers.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.beers.R
import com.example.beers.databinding.ActivityMainBinding
import com.example.beers.presentation.fragment.BeerListFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBeerListFragment()
    }

    private fun setupBeerListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, BeerListFragment.newInstance())
            .commit()
    }
}