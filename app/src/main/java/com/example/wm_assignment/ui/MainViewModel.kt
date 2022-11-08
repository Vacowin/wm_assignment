package com.example.wm_assignment.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wm_assignment.api.WalmartApiService
import com.example.wm_assignment.api.asDomain
import com.example.wm_assignment.domain.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val countries: MutableLiveData<List<Country>> by lazy { MutableLiveData() }

    fun loadCountries() {
        viewModelScope.launch {
            try {
                val countryList = withContext(Dispatchers.IO) {
                    WalmartApiService.newInstance().getCountries().asDomain()
                }
                countries.value = countryList
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