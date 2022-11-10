package com.example.wm_assignment.ui

import android.util.Log
import androidx.lifecycle.*
import com.example.wm_assignment.domain.Country
import com.example.wm_assignment.repository.CountryRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: CountryRepository) : ViewModel() {

    private val countries = MutableLiveData<List<Country>>().also {
        viewModelScope.launch {
            try {
                it.postValue(repository.getCountries())
            }
            catch (e: Exception) {
                Log.d("MainViewModel", "get countries error " + e.message)
            }
        }
    }

    fun getCountries(): LiveData<List<Country>> {
        return countries
    }
}