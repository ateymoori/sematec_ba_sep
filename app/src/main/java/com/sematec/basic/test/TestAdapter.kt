package com.sematec.basic.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.sematec.basic.R


class TestAdapter(val context: Context, val items: MutableList<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): String {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val rowView: View =
            LayoutInflater.from(context).inflate(R.layout.channels_list_item, p2, false)

        rowView.findViewById<TextView>(R.id.channelName).text = getItem(position)

        return rowView
    }
}