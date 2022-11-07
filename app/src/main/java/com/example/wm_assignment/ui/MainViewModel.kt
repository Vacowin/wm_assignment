package com.example.wm_assignment.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wm_assignment.domain.Country
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val countries: MutableLiveData<List<Country>> by lazy { MutableLiveData() }

    fun loadCountries() {
        viewModelScope.launch {
            try {
                load()
            }
            catch (e: Exception) {
                Log.d("MainViewModel", "get countries err " + e.message)
            }
        }
    }

    fun getCountries(): LiveData<List<Country>> {
        return countries
    }

    //TODO: Load from mock data
    private fun load() {
        val list = ArrayList<Country>()
        list.add(Country("Afghanistan","AS","AF","Kabul"))
        list.add(Country("Åland Islands","EU","AX","Mariehamn"))
        list.add(Country("Albania","EU","AL","Tirana"))

        countries.value = list
    }
}