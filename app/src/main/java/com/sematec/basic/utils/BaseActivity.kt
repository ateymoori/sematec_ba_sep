package com.sematec.basic.utils

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity(
    val isDialog: Boolean = false ,
    val isFullScreen : Boolean = false

) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isDialog) {
            //remove activity title bar
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
            setFinishOnTouchOutside(false)
        }

        if( isFullScreen){
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }


    }
}