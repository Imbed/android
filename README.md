# Android Imbed

Uses a [WebView](http://developer.android.com/reference/android/webkit/WebView.html) to show local html in the native app. Then call Java code from Javascript and vice versa.

## Features
* WebView is full screen (no title bar)
* Android Back button goes back in WebView
* Loads local html in /assets folder
* Allows visiting links to external urls in a new browser window (outside app)
* Java <-> Javascript bridge (at least examples)

## CAUTION

from [Android WebView Guide](http://developer.android.com/guide/webapps/webview.html)

>When the HTML in the WebView is untrustworthy (for example, part or all of the HTML is provided by an unknown person or process), then an attacker can include HTML that executes your client-side code and possibly any code of the attacker's choosing. As such, you should not use addJavascriptInterface() unless you wrote all of the HTML and JavaScript that appears in your WebView. You should also not allow the user to navigate to other web pages that are not your own, within your WebView (instead, allow the user's default browser application to open foreign links—by default, the user's web browser opens all URL links, so be careful only if you handle page navigation as described in the following section).

This application is set up to notice any links that are clicked on with urls that aren't using the `file:///` protocol and will ask the system to open that URL outside of the application (i.e. in Chrome or whatever browser the user wants).

