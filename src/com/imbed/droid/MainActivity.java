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
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("file:///android_asset/test.html");
        myWebView.getSettings().setJavaScriptEnabled(true);
    }

    /** allow the back button to go back in the webview */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
      if(event.getAction() == KeyEvent.ACTION_DOWN){
          switch(keyCode)
          {
          case KeyEvent.KEYCODE_BACK:
            if(myWebView.canGoBack()){
              myWebView.goBack();
            }else{
              finish();
            }
            return true;
          }
      }
      return super.onKeyDown(keyCode, event);
    }
}
