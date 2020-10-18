package com.sematec.basic.mvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sematec.basic.R
import com.sematec.basic.activities.MainActivity
import com.sematec.basic.adapters.PixabayAdapter
import com.sematec.basic.entities.HitsEntity
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_image_search_engine.*

class MVPActivity : AppCompatActivity(), Contract.View {

    lateinit var presenter: Contract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_search_engine)

        presenter = MVPPresenter(this)

        search.setOnClickListener {
            presenter.search(word.text.toString())
        }
    }

    override fun onResults(result: MutableList<HitsEntity>) {
        //runOnUiThread {
        val adapter = PixabayAdapter(this, result)
        results.adapter = adapter
        // }
    }

    override fun onError(msg: String?) {
        //runOnUiThread {
        msg?.toast()
        // }
    }

    override fun onLoading(show: Boolean) {
        //  runOnUiThread {
        refreshLayout.isRefreshing = show
        // }
    }
}