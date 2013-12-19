/*
 * Author: 			Cory Green
 * 
 * Project:			Widget_take2
 * 
 * Date:			Dec 19, 2013
 * 
 */
package com.Cory.widget_take2;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;


// my about me section :)
public class About extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
		// targetting my webView and giving it access to javascript
		WebView myWebView = (WebView)findViewById(R.id.webview);
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true); 
		
		myWebView.addJavascriptInterface(new JSInterface(this), "Android");

		myWebView.loadUrl("file:///android_asset/main.html");

		
		
		
	}
	
	
	
	
}
