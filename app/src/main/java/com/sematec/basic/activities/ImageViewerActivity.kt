package com.sematec.basic.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sematec.basic.R
import kotlinx.android.synthetic.main.activity_image_viewer.*

class ImageViewerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_viewer)



        Glide
            .with(this)
            .load("https://pixabay.com/get/57e8d4474a51ae14f1dc8460da29317e143ddce75b5271_640.jpg")
            .centerCrop()
            .placeholder(R.drawable.material)
            .into(image);


    }
}