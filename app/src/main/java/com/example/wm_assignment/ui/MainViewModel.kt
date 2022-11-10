package com.example.wm_assignment.ui

import androidx.lifecycle.*
import com.example.wm_assignment.api.ApiExceptionHandler
import com.example.wm_assignment.domain.Country
import com.example.wm_assignment.repository.CountryRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: CountryRepository) : ViewModel() {

    private val countries = MutableLiveData<List<Country>>().also {
        viewModelScope.launch(ApiExceptionHandler.defaultHandler) {
            it.postValue(repository.getCountries())
        }
    }

    fun getCountries(): LiveData<List<Country>> {
        return countries
    }
}