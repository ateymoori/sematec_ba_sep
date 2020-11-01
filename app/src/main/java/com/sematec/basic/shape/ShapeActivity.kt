package com.sematec.basic.shape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.R
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_shape.*

class ShapeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape)


        update.setOnClickListener {
            enableDisable.isEnabled = !enableDisable.isEnabled
        }

        enableDisable.setOnClickListener {
            "It's working!".toast()
        }
    }
}