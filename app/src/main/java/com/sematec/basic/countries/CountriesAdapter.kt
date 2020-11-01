package com.sematec.basic.countries

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.sematec.basic.R

class CountriesAdapter(val context: Context, val items: List<CountryEntity>) : BaseAdapter() {

    override fun getItem(position: Int): CountryEntity {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.country_list_item, p2, false)
        val name = view.findViewById<TextView>(R.id.name)
        val population = view.findViewById<TextView>(R.id.population)

        name.text = getItem(position).name
        population.text = getItem(position).population.toString()

        return view
    }
}