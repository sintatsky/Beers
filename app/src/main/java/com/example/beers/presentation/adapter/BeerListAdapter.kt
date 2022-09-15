package com.example.beers.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.beers.databinding.BeerItemBinding
import com.example.beers.domain.entity.BeerItem
import com.squareup.picasso.Picasso

class BeerListAdapter : ListAdapter<BeerItem, BeerListAdapter.ViewHolder>(DiffUtilsBeerList()) {

    lateinit var onBeerItemClick: (String) -> Unit

    class ViewHolder(val binding: BeerItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BeerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        with(holder.binding){
            tvBeerName.text = data.name
            tvBeerTagline.text = data.tagline
            tvBeerDescription.text = data.description
            Picasso.get().load(data.image_url).into(ivLogoBeer)
            root.setOnClickListener {
                onBeerItemClick(data.name)
            }
        }
    }
}