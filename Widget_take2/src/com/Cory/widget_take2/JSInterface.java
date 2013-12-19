package com.Cory.widget_take2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.renderscript.RenderScript.ContextType;
import android.sax.StartElementListener;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JSInterface extends Activity{

	Context _context;
	
	// constructor
	JSInterface(Context context) {
		
		_context = context;
	}
	
	@JavascriptInterface
	public void uselessMethod(String name, String feedBack){
		Toast.makeText(_context, name + " " + feedBack, Toast.LENGTH_SHORT).show();

		try{
			//Intent newIntent = new Intent(getBaseContext(), FeedBackActivity.class);
			//newIntent.putExtra("name", name);
			//newIntent.putExtra("feedBack", feedBack);
		
			//startService(newIntent);
			
		}catch(Exception e){
			Log.e("error", e.getMessage().toString());
		}
	}
}
