package com.sematec.basic.countries

class CountryPresenter(val view:CountryContract.View) : CountryContract.Presenter {

    lateinit var model:CountryContract.Model
    init {
        model = CountryModel(this)
    }

    override fun loadCountries() {
        model.getCountries()
    }

    override fun addCountry(country: CountryEntity) {
       model.addCountry(country)
    }

    override fun countryAdded() {
        view.onCountryAdded()
        model.getCountries()
    }

    override fun onCountries(countries: List<CountryEntity>) {
        view.onCountries(countries)
    }

    override fun clearCountries() {
        model.clearCountries()
    }

    override fun onCountriesCleared() {
        view.onCountriesCleared()
        model.getCountries()
    }
}