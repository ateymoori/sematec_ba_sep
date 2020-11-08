package com.sematec.basic.web_view

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.sematec.basic.R
import kotlinx.android.synthetic.main.activity_web_view.*


class WebViewActivity : AppCompatActivity() {

    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        dialog = ProgressDialog(this)
        dialog.setTitle("Please wait")
        dialog.setCanceledOnTouchOutside(false)


        webView.settings.javaScriptEnabled = true

        // webView.webViewClient = WebViewClient()
        webView.webViewClient = MyWebViewClient(dialog)

        openURL.setOnClickListener {
            if (url.text.toString().isEmpty()) {
                url.error = "URL is mandatory"
                return@setOnClickListener
            }

            webView.loadUrl(url.text.toString())
        }

        openByBrowser.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(url.text.toString()))
            startActivity(browserIntent)
        }

    }

    class MyWebViewClient(val dialog: Dialog) : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            dialog.show()
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            dialog.dismiss()
        }
    }


}