package com.sematec.basic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.sematec.basic.R

class StudentsListAdapter(
    val context: Context,
    val students: MutableList<String>
) : BaseAdapter() {

    override fun getCount(): Int {
        return students.size
    }

    override fun getItem(position: Int): String {
        return students.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val view: View =
            LayoutInflater.from(context).inflate(
                R.layout.student_list_item,
                p2, false
            )

        val nameFamily = view.findViewById<TextView>(R.id.nameFamily)
        val mobile = view.findViewById<TextView>(R.id.mobile)
        val avatar = view.findViewById<ImageView>(R.id.avatar)

        nameFamily.text = getItem(position)

        return view
    }
}









