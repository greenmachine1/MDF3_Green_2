package com.Cory.week_1;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText emailAddress;
	EditText subject;
	EditText body;
	
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
        
        emailAddress = (EditText)findViewById(R.id.email_address_text_field);
        subject = (EditText)findViewById(R.id.subject_text_field);
        body = (EditText)findViewById(R.id.body_text_field);
        
        try{
        	
        	// creating a bundle to hold all the extras that come along with
        	// the intent
        	Bundle dataString = intent.getExtras();
        	
        	String subjectString = dataString.get(Intent.EXTRA_SUBJECT).toString();
        	String bodyString = dataString.get(Intent.EXTRA_TEXT).toString();
        	
        	
        	subject.setHint(subjectString);
        	body.setHint(bodyString);
        	
        	Log.i("Email", subjectString);
        	Log.i("Body", bodyString);
        	
        }catch(Exception e){
        	
        	Log.e("no data", e.toString());
        	
        }
        
        
        
        
        
        
        
        
        /*
        Intent intent = getIntent();
       
        String type = intent.getType();
        
        // works to pass on the data type
        if(type != null){
        	
        	// this handles if the text is plain...
        	if(type.equals("text/plain")){
        		
        		Log.i("Type", "text plain");
        		
        		intent.getExtras();
        		
        	// ...or not	
        	}else{
        		Log.i("Type", "different");
        	}
        	
        // what to do if there is no type available	
        }else{
        	Log.i("No Data", "No data");
        }
        
        */
        
       
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
