package com.Cory.JSON;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;

public class JSONProvider extends Activity{
	
	public JSONProvider(){
		super();
	}
	
	public void OnHandle(){
		
	}
	
	Context _context;
	
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
	


}
