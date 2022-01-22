package com.example.androidcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class MainActivity2 : AppCompatActivity() {

    private lateinit var webView1Button: Button
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        webView = findViewById(R.id.webView)
        webView1Button = findViewById(R.id.webView1_button)
        webView1Button.setOnClickListener { webView() }
    }

    /**
     * WebView
     * // update Manifest file
     * <uses-permission android:name="android.permission.INTERNET"/>
     * */
    private fun webView() {
        // load web inside this activity
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }
        }
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.youtube.com/")
    }
}