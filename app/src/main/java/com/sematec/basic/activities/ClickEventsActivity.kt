package com.sematec.basic.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.sematec.basic.R
import com.sematec.basic.utils.AppUtils
import com.sematec.basic.utils.AppUtils.Companion.toast
import com.sematec.basic.utils.Constants.Companion.MIN_NAME_VALID_SIZE
import kotlinx.android.synthetic.main.activity_click_events.*

class ClickEventsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        save.setOnClickListener {
            val myNameValue = myName.text.toString()

            if (myNameValue.length < MIN_NAME_VALID_SIZE) {
                myName.error = getString(R.string.name_invalid)
                return@setOnClickListener
            }

//            Toast.makeText(this, myNameValue, Toast.LENGTH_SHORT).show()

            AppUtils.toast(this, myNameValue)
            toast(this, myNameValue)

//            Log.d("app_debug", myNameValue)
            AppUtils.log(myNameValue)


            //switch to DestinationActivity
            val destinationIntent = Intent(this, DestinationActivity::class.java)
            destinationIntent.putExtra("my_name", myNameValue)
            destinationIntent.putExtra("my_age", 31)

            startActivity(destinationIntent)
        }


        getCountry.setOnClickListener {
            val countryIntent = Intent(this, DestinationActivity::class.java)
            startActivityForResult(countryIntent, 1000)
        }


        openGoogle.setOnClickListener {
            val googleIntent = Intent(Intent.ACTION_VIEW , Uri.parse("http://google.com"))
            startActivity(googleIntent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            if( resultCode== Activity.RESULT_OK){
                val country = data?.getStringExtra("country")
                toast(this , "your country is $country")
            }
            //user returned from Destination activity to getting the country
        }
    }
}