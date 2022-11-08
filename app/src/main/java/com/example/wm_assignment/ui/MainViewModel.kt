package com.example.wm_assignment.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wm_assignment.domain.Country
import com.example.wm_assignment.repository.CountryRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: CountryRepository) : ViewModel() {
    private val countries: MutableLiveData<List<Country>> by lazy { MutableLiveData() }

    fun loadCountries() {
        viewModelScope.launch {
            try {
                countries.value = repository.getCountries()
            }
            catch (e: Exception) {
                Log.d("MainViewModel", "get countries err " + e.message)
            }
        }
    }

    fun getCountries(): LiveData<List<Country>> {
        return countries
    }
}