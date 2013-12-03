package com.Cory.week_1;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // setting the screen to be full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.main);
        
        // in my android manifest, I had to specify the name, category, and data
        // to be used so that my app shows up in a list of all those to choose
        // from.
        
        
        Intent intent = getIntent();
       
        String data = intent.getType();
        
        // works to pass on the data type
        if(data != null){
        	
        	// this handles if the text is plain...
        	if(data.equals("text/plain")){
        		
        		Log.i("Type", "text plain");
        		
        	// or not	
        	}else{
        		Log.i("Type", "different");
        	}
        }else{
        	Log.i("No Data", "No data");
        }
        
        
        
       
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
