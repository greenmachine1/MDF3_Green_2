package com.Cory.SimpText;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.telephony.SmsManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView topText;
	EditText emailAddress;
	EditText body;
	
	String[] emailString;
	String bodyString;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // setting the screen to be full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.main);
        
        topText = (TextView)findViewById(R.id.textView1);
        
        // calling on my display metrics to gather info about the screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        
        // getting an int value for the placement of my top text
        int width = displayMetrics.widthPixels;
        int finalWidth = (width / 2) - 90;
        
        // setting the top text padding
        topText.setPadding(finalWidth, 0, 0, 0);        
        
        // in my android manifest, I had to specify the name, category, and data
        // to be used so that my app shows up in a list of all those to choose
        // from.
        
        // gathers info about the calling intent
        Intent intent = getIntent();
        
        emailAddress = (EditText)findViewById(R.id.email_address_text_field);
        body = (EditText)findViewById(R.id.body_text_field);
        
        try{
        	
        	// creating a bundle to hold all the extras that come along with
        	// the intent
        	Bundle dataString = intent.getExtras();
        	
        	// grabbing my email string array
        	emailString = dataString.getStringArray(Intent.EXTRA_EMAIL);
        	bodyString = dataString.get(Intent.EXTRA_TEXT).toString();
        	
        	// setting the fields to contain the info
        	emailAddress.setText(emailString[0].toString());
        	body.setText(bodyString);
        	
        	
        	// creating my send button
        	Button sendButton = (Button)findViewById(R.id.send_button);
        	sendButton.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					
					// calling on my sendTextMessage method
					sendTextMessage();
				}
        		
        	});
        	
        }catch(Exception e){
        	
        	Log.e("no data", e.toString());
        	
        }

    }
    
    
    
    // made a method for actually sending out the message
    public void sendTextMessage(){
    	
    	// calling on my sms manager
    	SmsManager sms = SmsManager.getDefault();
    	
    	// grabbing the most current info from the text fields
    	String sendAddress = emailAddress.getText().toString();
    	String bodyText = body.getText().toString();
    	
    	// method that actually sends out the text message
        sms.sendTextMessage(sendAddress, null, bodyText, null, null);
    }
    
}
