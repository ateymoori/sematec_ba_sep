package com.sematec.basic.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.R
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_country_list.*

class CountryListActivity : AppCompatActivity(), CountryContract.View {

    lateinit var presenter: CountryContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_list)

        presenter = CountryPresenter(this)

        save.setOnClickListener {
            val country = CountryEntity(
                name = name.text.toString(),
                population = population.text.toString().toInt(),
                continent = continent.text.toString(),
                flag = "",
            )
            presenter.addCountry(country)
        }

        clear.setOnClickListener {
            presenter.clearCountries()
        }

    }

    override fun onCountries(countries: List<CountryEntity>) {
        val adapter = CountriesAdapter(this, countries)
        countryList.adapter = adapter
    }

    override fun onCountryAdded() {
        name.setText("")
        population.setText("")
        continent.setText("")
        "New country has been added.".toast()
    }

    override fun onCountriesCleared() {

    }

    override fun onStart() {
        super.onStart()
        presenter.loadCountries()
    }
}