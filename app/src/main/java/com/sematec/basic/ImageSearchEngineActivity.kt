package com.sematec.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.TextHttpResponseHandler
import com.sematec.basic.adapters.PixabayAdapter
import com.sematec.basic.entities.HitsEntity
import com.sematec.basic.entities.PixabayEntity
import com.sematec.basic.utils.log
import com.sematec.basic.utils.toast
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_image_search_engine.*

class ImageSearchEngineActivity : AppCompatActivity() {

    val url = "https://pixabay.com/api/?key=14649220-5ae78e4612f86b869152790a4&q="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_search_engine)

        search.setOnClickListener {
            searchImage(word.text.toString())
        }
    }

    private fun searchImage(word: String) {

        val client = AsyncHttpClient()
        val restURL = "$url$word"
        restURL.log("pixabay_result")


        client.get(restURL, object : TextHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?
            ) {
                parseResult(responseString)
                responseString?.log("pixabay_result")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?,
                throwable: Throwable?
            ) {

            }

        })

    }

    private fun parseResult(serverResults: String?) {
        val gson = Gson()
        val pixabay = gson.fromJson(
            serverResults,
            PixabayEntity::class.java
        )

        if (pixabay.totalHits == 0) {
            "No results from server".toast()
            return
        } else {
            "${pixabay.totalHits} results has been found".toast()
            val images = pixabay.hits.take(30)

            val adapter = PixabayAdapter(this, images as MutableList<HitsEntity>)
            results.adapter = adapter
        }

    }
}