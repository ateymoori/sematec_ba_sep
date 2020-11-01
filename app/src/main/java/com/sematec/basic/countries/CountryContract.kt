package com.sematec.basic.countries

interface CountryContract {


    interface View {
        fun onCountries(countries: List<CountryEntity>)
        fun onCountryAdded()
        fun onCountriesCleared()
    }

    interface Presenter {
        fun loadCountries()
        fun addCountry(country: CountryEntity)
        fun countryAdded()
        fun onCountries(countries: List<CountryEntity>)
        fun clearCountries()
        fun onCountriesCleared()
    }

    interface Model {
        fun addCountry(country: CountryEntity)
        fun getCountries()
        fun clearCountries()
    }

}