package com.sematec.basic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.sematec.basic.R
import com.sematec.basic.entities.DrawerItemEntity
import com.sematec.basic.utils.load
import org.w3c.dom.Text

class DrawerListAdapter(val context: Context, val items: MutableList<DrawerItemEntity>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): DrawerItemEntity {
        return items.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.drawer_item, p2, false)

        val title = view.findViewById<TextView>(R.id.title)
        val counter = view.findViewById<TextView>(R.id.counter)
        val image = view.findViewById<ImageView>(R.id.imageView)

        title.text = getItem(position).title
        counter.text = getItem(position).count.toString()

        image.load(context, getItem(position).icon)

        return view
    }
}