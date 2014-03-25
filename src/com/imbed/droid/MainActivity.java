package com.imbed.droid;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.content.Intent;

import android.util.Log;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.view.KeyEvent;

import com.imbed.droid.DroidWebViewClient;
import com.imbed.droid.WebAppInterface;

public class MainActivity extends Activity
{
    private static final String TAG = "MainActivity";
    private WebView myWebView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        myWebView = (WebView) findViewById(R.id.webview);

        // set WebViewClient to handle external url links
        myWebView.setWebViewClient(new DroidWebViewClient());

        // Enable JS
        myWebView.getSettings().setJavaScriptEnabled(true);

        // Set web app interface to give your JS an Android API
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        // Load your local webpage
        myWebView.loadUrl("file:///android_asset/index.html");
    }

    /** allow the back button to go back in the webview */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
      // Check if the key event was the Back button and if there's history
      if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
          myWebView.goBack();
          return true;
      }
      // system behavior (probably exit the activity)
      return super.onKeyDown(keyCode, event);
    }
}
