package com.qoolqas.materialdesign.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.qoolqas.materialdesign.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView.loadUrl("http://idn.id")
        webView.webViewClient
    }
}
