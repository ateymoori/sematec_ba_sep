package com.sematec.basic.countries

import com.sematec.basic.api.WebService
import com.sematec.basic.utils.MyApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryModel(val presenter: CountryContract.Presenter) : CountryContract.Model {

    override fun addCountry(country: CountryEntity) {
        MyApplication.database.addCountry(country)
        presenter.countryAdded()
    }

    override fun getCountries() {
        WebService.api.getCountries().enqueue(object : Callback<List<CountryEntity>> {
            override fun onFailure(call: Call<List<CountryEntity>>, t: Throwable) {
                //get data from DB in errors
                MyApplication.database.getCountries()?.let {
                    presenter.onCountries(it)
                }
            }

            override fun onResponse(
                call: Call<List<CountryEntity>>,
                response: Response<List<CountryEntity>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        //return data to other layers
                        presenter.onCountries(it)
                        //clear db
                        MyApplication.database.cleanCountries()
                        //store data in database
                        it.forEach {
                            MyApplication.database.addCountry(it)
                        }
                    }
                } else {
                    //error in connection to server
                    //get data from DB in errors
                    MyApplication.database.getCountries()?.let {
                        presenter.onCountries(it)
                    }
                }
            }
        })
    }

    override fun clearCountries() {
        MyApplication.database.cleanCountries()
        presenter.onCountriesCleared()
    }

}