package com.sematec.basic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.sematec.basic.R
import com.sematec.basic.entities.HitsEntity
import com.sematec.basic.utils.load

//image search engine by pixabay
//weather app by yahoo
//omdbapi


class PixabayAdapter(val context: Context, val items: MutableList<HitsEntity>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): HitsEntity {
        return items.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val view: View =
            LayoutInflater.from(context).inflate(
                R.layout.pixabay_results_item,
                p2, false
            )

        val tags = view.findViewById<TextView>(R.id.tags)
        val image = view.findViewById<ImageView>(R.id.image)

        tags.text = getItem(position).tags
        image.load(context, getItem(position).largeImageURL)

        return view
    }
}