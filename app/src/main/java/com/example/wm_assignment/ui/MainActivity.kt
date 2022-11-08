package com.example.wm_assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.wm_assignment.CountryFactory
import com.example.wm_assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(CountryFactory.getRepository())
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        setUpUI()
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadCountries()
    }

    private fun setUpUI() {
        val countryListAdapter = CountryListAdapter()
        binding.countryRecyclerview.adapter = countryListAdapter

        viewModel.getCountries().observe(this) { countries ->
            countryListAdapter.itemList = countries
        }
    }
}