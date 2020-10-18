package com.sematec.basic.add_edit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.R
import com.sematec.basic.utils.Constants.Companion.EDIT_MODE
import kotlinx.android.synthetic.main.activity_origin.*

class OriginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_origin)

        val destinationIntent = Intent(this, DestinationActivity::class.java)


        add.setOnClickListener {
            destinationIntent.putExtra(EDIT_MODE, false)
            startActivity(destinationIntent)
        }


        edit.setOnClickListener {
            destinationIntent.putExtra(EDIT_MODE, true)
            startActivity(destinationIntent)
        }

    }
}