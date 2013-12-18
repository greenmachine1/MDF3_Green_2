package com.Cory.JSON;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.Cory.JSON.WebInfo;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* The point of this service call is to basically load my json data into
 * storage behind the scenes
 */

public class JSON extends IntentService{

	public static final String NAME = "messenger";
	public static final String KEY = "key";
	
	public JSON() {
		super("JSON");
		
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		
		
		Bundle extras = intent.getExtras();
		
		Messenger messenger = (Messenger) extras.get(NAME);
		//String keyOfThings = (String) extras.get(KEY);

		// obtaining my object that gets returned from my Json Data
		Message message = Message.obtain();
		message.arg1 = Activity.RESULT_OK;
		message.obj = returnJsonData();
		
		try {
			messenger.send(message);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			Log.i("OnHandleIntent", e.getMessage().toString());
			e.printStackTrace();
		}
		
	}
	
	// get the json data
	public String returnJsonData(){
		
		// creation of url
		String completeURL = "https://api.coindesk.com/v1/bpi/currentprice.json";
		
		URL finalURL = null;
			try {
				finalURL = new URL(completeURL);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// creating a temp string to hold the response
			String response = "";
			response = WebInfo.getURLStringResponse(finalURL);

		return response;
	}
}