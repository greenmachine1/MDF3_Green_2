package com.Cory.widget_take2;

import org.json.JSONObject;

import com.Cory.JSON.FileManager;
import com.Cory.JSON.JSON;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RemoteViews;
import android.widget.RadioButton;

public class WidgetConfigActivity extends Activity implements OnClickListener{
	
	EditText userInput;
	Context _context;
	
	RadioGroup radioGroup1;
	RadioGroup radioGroup2;
	
	String currencySelected;

	String amount;
	String symbol;
	
	String fileName = "JSON_file.txt";
	FileManager newFileManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configure_main);
		// have to set R.layout.configure to configure_main
		
		
		_context = this;
		
		Button doneButton = (Button)this.findViewById(R.id.done_button);
		doneButton.setOnClickListener(this);

		// selecting my radiogroup1
		radioGroup1 = (RadioGroup)this.findViewById(R.id.currency_group);

		newFileManager = new FileManager();
		
	
	}

	// this is the done button 
	@Override
	public void onClick(View v) {
		
		// gathering the radio button input
		RadioButton selectedButton = (RadioButton)findViewById(radioGroup1.getCheckedRadioButtonId());

		// input from the user
		currencySelected = selectedButton.getText().toString();

		Log.i("Button", selectedButton.getText().toString());

		
		// so basically what I need to do next, is 1). 
		// be able to access the api and pull info from it to the widget.
		
		/* section that calls on the json data and updates it */
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			
			int widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, 
										 AppWidgetManager.INVALID_APPWIDGET_ID);
			
			// if we get a valid widgetID back then...
			if(widgetId != AppWidgetManager.INVALID_APPWIDGET_ID){

				
				// grabbing my widget text view and buttons
				RemoteViews remoteView = new RemoteViews(this.getPackageName(),R.layout.widget_layout);
				
				// my handler.  Handles the return info
				final Handler JsonHandler = new Handler(){

					@Override
					public void handleMessage(Message message){
						
						// what gets returned from the called service
						Object returnedObject = message.obj;
						
						// casting the object to a string
						String returnedObjectString = returnedObject.toString();
						
						if(message.arg1 == RESULT_OK && returnedObject != null){

							newFileManager.writeStringFile(_context, fileName, returnedObjectString);
					        
							parseJSONData(currencySelected);
					       
						}
					}
		    		
		    	}; 

				// creation of my messenger to the service
		    	Messenger jsonMessenger = new Messenger(JsonHandler);
				
				Intent myServiceIntent = new Intent(_context, JSON.class);
				
				// basically this passes info to my service
				myServiceIntent.putExtra("messenger", jsonMessenger);
				startService(myServiceIntent);

				
				
				// setting the initial display
				// this calls on my parsingJSONData method
				remoteView.setTextViewText(R.id.days_textview, parseJSONData(currencySelected));

				AppWidgetManager.getInstance(this).updateAppWidget(widgetId, remoteView);
			
				Intent resultValue = new Intent();
				
				resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
				setResult(RESULT_OK, resultValue);
				
				
				finish();
				
				
				
				
			}
	
		}
				
	}
	
	// method used to parse the data
	public String parseJSONData(String currencyType){
		String JSONString = newFileManager.readStringFile(this, fileName);

		// setting up my JSONObjects
		JSONObject jsonObject = null;
		JSONObject resultsObject = null;
		JSONObject currencyObject = null;
		
		try{
			// getting the json object and drilling it down
			jsonObject = new JSONObject(JSONString);
			resultsObject = jsonObject.getJSONObject("bpi");
			
			// passing in user input to lookup
			currencyObject = resultsObject.getJSONObject(currencyType);
			
			// gets the amount object
			amount = currencyObject.getString("rate").toString();
			if(currencyType.equals("USD")){
				symbol = "$";
			}else if(currencyType.equals("EUR")){
				symbol = "Û";
			}else if(currencyType.equals("GBP")){
				symbol = "£";
			}

		}catch(Exception e){
			Log.e("error", e.getMessage().toString());
			
		}
		
		// returns the amount
		return symbol +" "+ amount;
	}

}
