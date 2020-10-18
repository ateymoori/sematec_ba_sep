package com.sematec.basic.handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sematec.basic.R
import com.sematec.basic.utils.toast

class HandlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)
    }

    var backClicked = false

    override fun onBackPressed() {

        if (!backClicked) {
            //first time
            backClicked = true
            "Please click back again for close the app.".toast()
            Handler(mainLooper).postDelayed({
                backClicked = false
            }, 2000)
        } else {
            //second time
            finish()
        }

    }


}