package com.example.wm_assignment.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.wm_assignment.R
import com.example.wm_assignment.databinding.CountryItemLayoutBinding
import com.example.wm_assignment.domain.Country

class CountryItemViewHolder(private val binding: CountryItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(country: Country) {
        binding.countryItemNameRegion.text = binding.root.context.getString(
            R.string.country_item_name_region,
            country.name,
            country.region
        )
        binding.countryItemCode.text = country.code
        binding.countryItemCapital.text = country.capital
    }
}