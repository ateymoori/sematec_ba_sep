package com.sematec.basic.utils

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient

class Test : WebViewClient() {
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
    }

}