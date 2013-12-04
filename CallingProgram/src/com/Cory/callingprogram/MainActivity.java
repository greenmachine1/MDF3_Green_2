package com.Cory.callingprogram;

import org.apache.http.protocol.HTTP;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText sendTo;
	EditText subject;
	EditText body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        sendTo = (EditText)findViewById(R.id.send_to_text);
        subject = (EditText)findViewById(R.id.subject_text);
        body = (EditText)findViewById(R.id.body_text);
        
        
        // Thinking that the calling program will call upon an email
        // app.  Ill try to create my own.
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				// this intent will be sending something out as an email
				// so my main program will have to handle the action type
				// of send.
				
				
				
				
				Intent emailIntent = new Intent(Intent.ACTION_SEND);
				emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
				emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"greenmachine1@fullsail.edu"});
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, "sent from my phone");
				emailIntent.putExtra(Intent.EXTRA_TEXT, "Body of the email goes here");
				
				// starts the activity
				startActivity(emailIntent);
				
			}
        	
        });
        
        
        
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
