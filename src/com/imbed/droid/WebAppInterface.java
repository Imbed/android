package com.imbed.droid;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import android.util.Log;

public class WebAppInterface {
  Context mContext;
  private static final String TAG = "WebAppInterface";

  WebAppInterface(Context c){
    mContext = c;
  }

  /** Implement your JS API here... */

  @JavascriptInterface
  public void toast(String text) {
    Log.v(TAG, "got text = " + text);
    Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
  }

}
