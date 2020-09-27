package com.sematec.basic.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sematec.basic.R
import com.sematec.basic.test.TestAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        list.adapter = TestAdapter(
            context = this,
            items = mutableListOf("sdvsdv", "ssdcs", "sdcsdcs")
        )

        list.setOnItemClickListener { adapterView, view, position, l ->

        }

        Log.d("lifecycle_debug", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle_debug", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle_debug", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle_debug", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle_debug", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle_debug", "onDestroy")
    }

    private fun getMyName(): String {
        return "AmirHossein"
    }
}