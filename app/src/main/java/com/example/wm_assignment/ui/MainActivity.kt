package com.example.wm_assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.wm_assignment.CountryFactory
import com.example.wm_assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(CountryFactory.getRepository())
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpUI()
        observeViewModel()
    }

    private fun setUpUI() {
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val countryListAdapter = CountryListAdapter()
        binding.countryRecyclerview.adapter = countryListAdapter
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.getCountries().observe(this@MainActivity) { countries ->
                (binding.countryRecyclerview.adapter as CountryListAdapter).itemList = countries
            }
        }
    }
}