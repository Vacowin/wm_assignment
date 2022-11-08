package com.example.wm_assignment.api

import com.example.wm_assignment.domain.Country

data class CountryDTO (
    val capital: String,
    val code: String,
    val currency: CurrencyDTO,
    val flag: String,
    val language: LanguageDTO,
    val name: String,
    val region: String
)

data class CurrencyDTO (
    val code: String,
    val name: String,
    val symbol: String?
)

data class LanguageDTO (
    val code: String?,
    val name: String
)

fun List<CountryDTO>.asDomain(): List<Country> {
    return map {
        Country(
            name = it.name,
            region = it.region,
            code = it.code,
            capital = it.capital
        )
    }
}