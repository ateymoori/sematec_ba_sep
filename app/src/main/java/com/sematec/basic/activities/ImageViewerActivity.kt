package com.sematec.basic.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sematec.basic.R
import com.sematec.basic.utils.load
import com.sematec.basic.utils.log
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_image_viewer.*

class ImageViewerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_viewer)

        image.load(
            this,
            "https://pixabay.com/get/57e8d4474a51ae14f1dc8460da29317e143ddce75b5271_640.jpg"
        )


        "My Name Is Amir".log()
        val age = 30

        "amir".toast()
    }
}