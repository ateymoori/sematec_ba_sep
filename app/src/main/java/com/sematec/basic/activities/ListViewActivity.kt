package com.sematec.basic.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.R
import com.sematec.basic.adapters.StudentsListAdapter
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val adapter = StudentsListAdapter(
            this,
            mutableListOf(
                "Alireza",
                "Mahdi",
                "Fariba",
                "Mostafa",
                "Mahdi",
                "Fariba",
                "Mostafa",
                "Mahdi",
                "Fariba",
                "Mostafa",
                "Mahdi",
                "Fariba",
                "Mostafa",
                "Mahdi",
                "Fariba",
                "Mostafa",
                "Mahdi",
                "Fariba",
                "Mostafa",
                "Mahdi",
                "Fariba",
                "Mostafa"
            )

        )

        friendsList.adapter = adapter


        friendsList.setOnItemClickListener { adapterView, view, position, l ->
            val clickedItem = adapterView.getItemAtPosition(position) as String
            clickedItem.toast()
        }


    }
}