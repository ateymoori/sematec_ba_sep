package com.sematec.basic.room_practice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.sematec.basic.R
import com.sematec.basic.room.Book

class BooksAdapter(val context: Context, val items: List<Book>) : BaseAdapter() {

    override fun getItem(position: Int): Book {
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
        population.text = getItem(position).author.toString()

        return view
    }
}