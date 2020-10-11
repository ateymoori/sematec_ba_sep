package com.sematec.basic.mvp

import android.widget.Toast
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.TextHttpResponseHandler
import com.sematec.basic.api.Api
import com.sematec.basic.api.WebService
import com.sematec.basic.entities.HitsEntity
import com.sematec.basic.entities.PixabayEntity
import com.sematec.basic.utils.Constants.Companion.PIXABAY_API_KEY
import com.sematec.basic.utils.log
import cz.msebera.android.httpclient.Header
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MVPPresenter(val view: Contract.View) : Contract.Presenter {

    //as presenter and model layer
    val url = "https://pixabay.com/api/?key=14649220-5ae78e4612f86b869152790a4&q="


    override fun search(word: String) {
        //  searchImage(word)
        searchByRetrofit(word)
    }


    private fun searchImage(word: String) {
        val client = AsyncHttpClient()
        val restURL = "$url$word"
        client.get(restURL, object : TextHttpResponseHandler() {
            override fun onStart() {
                super.onStart()
                view.onLoading(true)
            }

            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?
            ) {
                parseResult(responseString)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?,
                throwable: Throwable?
            ) {
                view.onError(responseString)
            }

            override fun onFinish() {
                super.onFinish()
                view.onLoading(false)
            }
        })

    }


    private fun searchByRetrofit(word: String) {
//        val retrofit =
//            Retrofit.Builder().baseUrl("https://pixabay.com/api/")
//                .addConverterFactory(GsonConverterFactory.create()).build()
//        val service = retrofit.create(Api::class.java)

        view.onLoading(true)

        WebService.api.getImages(
            word = word,
            key = PIXABAY_API_KEY
        ).enqueue(object : Callback<PixabayEntity> {
            override fun onResponse(call: Call<PixabayEntity>, response: Response<PixabayEntity>) {
                view.onResults(response.body()?.hits as MutableList<HitsEntity>)
                view.onLoading(false)
            }

            override fun onFailure(call: Call<PixabayEntity>, t: Throwable) {
                view.onError(t.message)
                view.onLoading(false)
            }

        })


//        Thread {
//            val response = service.getImages(
//                word = word,
//                key = PIXABAY_API_KEY
//            ).execute().body()
//
//            if (response?.totalHits == 0) {
//                view.onError("Results empty")
//            } else {
//                view.onResults(response?.hits as MutableList<HitsEntity>)
//            }
//        }.start()


    }

    private fun parseResult(serverResults: String?) {
        val gson = Gson()
        val pixabay = gson.fromJson(
            serverResults,
            PixabayEntity::class.java
        )

        if (pixabay.totalHits == 0) {
            view.onError("Results empty")
            return
        } else {

            val images = pixabay.hits.take(30)

            view.onResults(images as MutableList<HitsEntity>)


        }

    }

}