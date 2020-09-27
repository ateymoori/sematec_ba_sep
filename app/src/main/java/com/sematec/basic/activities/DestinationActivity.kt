package com.sematec.basic.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.R
import kotlinx.android.synthetic.main.activity_click_events.*
import kotlinx.android.synthetic.main.activity_destination.*

class DestinationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)

        val myName = intent.getStringExtra("my_name")
        val myAge = intent.getIntExtra("my_age", 0)

        result.text = "Your name is : $myName and your age is : $myAge "


        backToForm.setOnClickListener {
            val countryValue = countryEditText.text.toString()

            val countryIntent = Intent()
            countryIntent.putExtra("country" ,countryValue )
            setResult(Activity.RESULT_OK , countryIntent)
            finish()


        }


    }
}