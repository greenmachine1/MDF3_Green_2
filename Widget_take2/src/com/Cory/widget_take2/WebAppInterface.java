package com.Cory.widget_take2;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {

	Context _context;
	
	// constructor
	WebAppInterface(Context context) {
		
		_context = context;
	}
	
	@JavascriptInterface
	public void uselessMethod(String something){
		Toast.makeText(_context, something, Toast.LENGTH_SHORT).show();

		
	}
	
	

}
