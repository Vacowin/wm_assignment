package com.example.wm_assignment

import com.example.wm_assignment.api.WalmartApiService
import com.example.wm_assignment.repository.CountryRepository
import com.example.wm_assignment.repository.CountryRepositoryImpl
import kotlinx.coroutines.Dispatchers

object CountryFactory {
    private var repository: CountryRepository? = null

    fun getRepository(): CountryRepository {
        repository?.let { return it }

        val apiService = WalmartApiService.newInstance()
        val repositoryImpl = CountryRepositoryImpl(apiService, Dispatchers.IO)
        repository = repositoryImpl
        return repositoryImpl
    }
}