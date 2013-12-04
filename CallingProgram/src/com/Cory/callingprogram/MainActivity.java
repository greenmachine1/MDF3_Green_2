/*
 * Author: 			Cory Green
 * 
 * Project:			CallingProgram
 * 
 * Date:			Dec 4, 2013
 * 
 */
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

        // button used to send off my info to a different app
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v){
				
				// this intent will be sending something out as an email
				// so my main program will have to handle the action type
				// of send.
				
				// capturing my entry fields into texts
				String sendText = sendTo.getText().toString();
				String subjectText = subject.getText().toString();
				String bodyText = body.getText().toString();
				
				// inputting all my captured strings into the intent
				Intent smsIntent = new Intent(Intent.ACTION_SEND);
				smsIntent.setType(HTTP.PLAIN_TEXT_TYPE);
				smsIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {sendText});
				smsIntent.putExtra(Intent.EXTRA_SUBJECT, subjectText);
				smsIntent.putExtra(Intent.EXTRA_TEXT, bodyText);
				
				// starts the activity
				startActivity(smsIntent);
				
			}
        	
        });
 
    }
    
}
