package com.sematec.basic.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.sematec.basic.countries.CountryEntity
import com.sematec.basic.utils.Constants.Companion.DB_FILE_NAME
import com.sematec.basic.utils.Constants.Companion.DB_VERSION

class DatabaseHandler(
    val context: Context
) : SQLiteOpenHelper(
    context ,
    DB_FILE_NAME ,
    null ,
    DB_VERSION
) {

    val countryTBL = "" +
            "CREATE TABLE countries ( " +
            "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "name TEXT ," +
            "population TEXT ," +
            "continent TEXT ," +
            "flag TEXT" +
            " )"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(countryTBL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addCountry(country:CountryEntity){
        val db = this.writableDatabase
        val insertQuery = "" +
                "INSERT INTO countries(name,population,continent,flag) " +
                "VALUES('${country.name}' , '${country.population.toString()}' ," +
                "'${country.continent}' , '${country.flag}'" +
                ")"
        db.execSQL(insertQuery)
        db.close()
    }

    fun getCountries():List<CountryEntity>?{
        val countryList = mutableListOf<CountryEntity>()

        val db = this.readableDatabase
        val readQuery = "SELECT name,population,continent,flag FROM countries"

        val cursor: Cursor = db.rawQuery(readQuery, null)

        while (cursor.moveToNext()){
            val country = CountryEntity(
                name = cursor.getString(0),
                population = cursor.getString(1).toInt(),
                continent = cursor.getString(2),
                flag = cursor.getString(3)
            )
            countryList.add(country)
        }

        return countryList
    }

    fun cleanCountries(){
        val db = this.writableDatabase
        val clearQuery = "DELETE FROM countries"
        db.execSQL(clearQuery)
        db.close()
    }


}