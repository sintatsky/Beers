package com.example.beers.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.beers.domain.entity.BeerItem

class DiffUtilsBeerList : DiffUtil.ItemCallback<BeerItem>() {
    override fun areItemsTheSame(oldItem: BeerItem, newItem: BeerItem) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: BeerItem, newItem: BeerItem) =
        oldItem == newItem
}