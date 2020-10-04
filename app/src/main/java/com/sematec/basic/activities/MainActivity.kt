package com.sematec.basic.activities

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.TextHttpResponseHandler
import com.sematec.basic.R
//import com.sematec.basic.test.PixabayModel
import com.sematec.basic.test.TestAdapter
import com.sematec.basic.utils.toast
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        list.adapter = TestAdapter(
            context = this,
            items = mutableListOf("Alireza", "Mohammad", "Javad")
        )

        list.setOnItemClickListener { adapterView, view, position, l ->

        }

//
//        Thread{
//            //call api
//            //get response from web
//            runOnUiThread {
//                open.text = "Save"
//            }
//        }.start()
//
//        Handler().post {
//            "sdcsdc".toast()
//        }
//

        test()

        open.setOnClickListener {
            if (!drawer.isDrawerOpen(Gravity.RIGHT)) {
                drawer.openDrawer(Gravity.RIGHT)
            }
        }
        close.setOnClickListener {
            if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                drawer.closeDrawer(Gravity.RIGHT)
            }
        }




        Thread {
                // Run on background thread
        }.start()

        runOnUiThread {
            // Run in on UI thread
        }
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

    fun test(){
//        val client = AsyncHttpClient()
//        client["https://pixabay.com/api/?key=14649220-5ae78e4612f86b869152790a4&q=rainbow", object : TextHttpResponseHandler() {
//            override fun onSuccess(
//                statusCode: Int,
//                headers: Array<out Header>?,
//                responseString: String?
//            ) {
//                 Log.d("dddaaa" , responseString?:"")
//
//                val gson = Gson()
//                val pixaResults = gson.fromJson<PixabayModel>( responseString , PixabayModel::class.java)
//                Log.d("dddaaa" , pixaResults.hits.get(0).largeImageURL)
//            }
//
//            override fun onFailure(
//                statusCode: Int,
//                headers: Array<out Header>?,
//                responseString: String?,
//                throwable: Throwable?
//            ) {
//             }
//
//        }]
    }
}