package com.example.wm_assignment.repository

import com.example.wm_assignment.api.WalmartApiService
import com.example.wm_assignment.api.asDomain
import com.example.wm_assignment.domain.Country
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CountryRepositoryImpl(
    private val apiService: WalmartApiService,
    private val dispatcher: CoroutineDispatcher
) : CountryRepository {

    override suspend fun getCountries(): List<Country> {
        return withContext(dispatcher) {
            apiService.getCountries().asDomain()
        }
    }
}