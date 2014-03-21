package com.imbed.droid;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.content.Intent;

import android.util.Log;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity
{
    private static final String TAG = "MainActivity";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://www.google.com");
    }
}
