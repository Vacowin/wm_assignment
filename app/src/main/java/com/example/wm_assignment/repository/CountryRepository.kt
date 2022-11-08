package com.example.wm_assignment.repository

import com.example.wm_assignment.domain.Country

interface CountryRepository {
    suspend fun getCountries(): List<Country>
}