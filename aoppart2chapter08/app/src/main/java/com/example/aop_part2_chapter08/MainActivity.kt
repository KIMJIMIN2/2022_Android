package com.example.aop_part2_chapter08

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private val goHomeButton: ImageButton by lazy {
        findViewById(R.id.goHomeButton)
    }

    private val addressBar: EditText by lazy {
        findViewById(R.id.addressBar)
    }

    private val goBackButton: ImageButton by lazy {
        findViewById(R.id.goBackButton)
    }

    private val goForwardButton: ImageButton by lazy {
        findViewById(R.id.goForwardButton)
    }

    private val webView: WebView by lazy {
        findViewById(R.id.webView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        bindViews()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initViews() {
        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(DEFAULT_URL)
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    private fun bindViews() {
        goHomeButton.setOnClickListener {
            webView.loadUrl(DEFAULT_URL)
        }
        addressBar.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                webView.loadUrl(v.text.toString())
            }
            return@setOnEditorActionListener false
        }

        goBackButton.setOnClickListener {
            webView.goBack()
        }

        goForwardButton.setOnClickListener {
            webView.goForward()
        }
    }
    companion object {
        private const val DEFAULT_URL = "https://naver.com"
    }
}
