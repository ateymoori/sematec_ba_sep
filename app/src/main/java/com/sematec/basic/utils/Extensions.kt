package com.sematec.basic.utils

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.sematec.basic.BuildConfig
import com.sematec.basic.R
import kotlinx.android.synthetic.main.activity_image_viewer.*


fun ImageView.load(ctx: Context, url: String) {
    Glide
        .with(ctx)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.material)
        .into(this)
}
fun ImageView.load(ctx: Context, file:Int) {
    Glide
        .with(ctx)
        .load(file)
        .centerCrop()
        .placeholder(R.drawable.material)
        .into(this)
}


fun String.log(tag: String = "sematec_debug") {
    if(BuildConfig.DEBUG){
        Log.d(tag, this)
    }
}

fun Int.log(tag: String = "sematec_debug") {
    this.toString().log(tag)
}


fun String.toast(){
    Toast.makeText(MyApplication.context , this , Toast.LENGTH_LONG).show()
}