/*
 * Author: 			Cory Green
 * 
 * Project:			Widget_take2
 * 
 * Date:			Dec 19, 2013
 * 
 */
package com.Cory.widget_take2;


import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import com.Cory.JSON.FileManager;
import com.Cory.JSON.JSON;
import com.Cory.JSON.JSONProvider;
import com.Cory.JSON.WebInfo;
import com.Cory.JSON.JSONProvider.infoRequest;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider{
	
	FileManager newFileManager;
	String fileName = "JSON_file.txt";
	
	String amount;
	
	RemoteViews remoteView;
	
	// called everytime the widget updates which is every 30 minutes
	public void onUpdate (Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		
		newFileManager = new FileManager();
		
		
		// iterating through each addWidgetId
		final int N = appWidgetIds.length;
		for(int i = 0; i < N; i++){
		
			int appWidgetId = appWidgetIds[i];
			remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			
			remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			
			remoteView.setTextViewText(R.id.days_textview, "Update");
			
			appWidgetManager.updateAppWidget(appWidgetId, remoteView);
			

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
				LoadWebPageASYNC newRequest = new LoadWebPageASYNC();
				newRequest.execute(finalURL);
				if(newRequest != null){
					
				}
		
				}catch(MalformedURLException e){
				Log.e("Bad Url", "malformed URL");
				finalURL = null;
				}

		}
	}
		
		private class LoadWebPageASYNC extends AsyncTask<URL, Void, String>{

			
			@Override
			protected String doInBackground(URL... urls) {
				
				String response = "";
				for(URL url: urls){
					response = WebInfo.getURLStringResponse(url);
				}

				return response;
				
			}
			
		
		
		@Override
		protected void onPostExecute(String result){
			

			// setting up my JSONObjects
			JSONObject jsonObject = null;
			JSONObject resultsObject = null;
			JSONObject currencyObject = null;
			try {

				jsonObject = new JSONObject(result);
				resultsObject = jsonObject.getJSONObject("bpi");
				
				// passing in user input to lookup
				currencyObject = resultsObject.getJSONObject("USD");
				
				String amount = currencyObject.getString("rate").toString();
				
				Log.i("update", amount);
				
				//newTextView.setText(amount);
				
				
				

				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.e("Nope", "No such file");
			}

			

		}
	
		}

	public void onDelete(Context context, int[] appWidgetIds){
				
	}

}

	

	
	


