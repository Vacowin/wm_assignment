package com.example.wm_assignment.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wm_assignment.databinding.CountryItemLayoutBinding
import com.example.wm_assignment.domain.Country

class CountryListAdapter : RecyclerView.Adapter<CountryItemViewHolder>() {

    var itemList = listOf<Country>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CountryItemLayoutBinding.inflate(layoutInflater, parent, false)
        return  CountryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.size
}