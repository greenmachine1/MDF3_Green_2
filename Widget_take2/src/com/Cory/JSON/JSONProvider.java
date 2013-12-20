/*
 * Author: 			Cory Green
 * 
 * Project:			Widget_take2
 * 
 * Date:			Dec 19, 2013
 * 
 */
package com.Cory.JSON;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.Cory.JSON.WebInfo;
import com.Cory.widget_take2.MainActivity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;



// this class will pull json data from apple api
public class JSONProvider extends MainActivity{

	Context _context;

	public static final Context Json = null;
	
	String fileName = "JSON_file.txt";
	
	FileManager fileManager;
	
	String finalString;
	
	String passedInValue;
	
	public JSONProvider(){
		_context = this;
	}
	
	
	
	
	public String returnJsonData(String passedInUserInput){	
		
		
		
		passedInValue = passedInUserInput;
		// creation of url

		String completeURL = "https://api.coindesk.com/v1/bpi/currentprice.json";
		String as = "";
	
		try{
			as = URLEncoder.encode(completeURL, "UTF-8");
		}catch(Exception e){
			Log.e("Bad URL", "Encoding problem");
			as = "";
		}
	
		URL finalURL;
		try{
			// dont actually need my UTF-8 involved in the url
			finalURL = new URL(completeURL);
			infoRequest newRequest = new infoRequest();
			newRequest.execute(finalURL);
			if(newRequest != null){
				return "Sure";
			}
	
			}catch(MalformedURLException e){
			Log.e("Bad Url", "malformed URL");
			finalURL = null;
			}
	
	
			return "nope";
		}
	
	
		// this actually sends out the request
		public class infoRequest extends AsyncTask<URL, Void, String>{

			@Override
			protected String doInBackground(URL... urls) {
				String response = "";
				for(URL url: urls){
					response = WebInfo.getURLStringResponse(url);
					
					
					
				}
	
				return response;
			}
			// this is what comes back!
			protected void onPostExecute(String result){
				super.onPostExecute(result);

				// setting up my JSONObjects
				JSONObject jsonObject = null;
				JSONObject resultsObject = null;
				JSONObject currencyObject = null;
				try {

					jsonObject = new JSONObject(result);
					resultsObject = jsonObject.getJSONObject("bpi");
					
					// passing in user input to lookup
					currencyObject = resultsObject.getJSONObject(passedInValue);
					
					String amount = currencyObject.getString("rate").toString();
					
					Log.i("amount", amount);
					
					// writting the result to a file
					fileManager = new FileManager();
					fileManager.writeStringFile(_context, "JSON_file.txt", result);
					
					
					
					

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.e("Nope", "No such file");
				}
	
				
	
			}
			
		}


		
}