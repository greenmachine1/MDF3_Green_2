package com.Cory.widget_take2;


import org.json.JSONObject;

import com.Cory.JSON.FileManager;
import com.Cory.JSON.JSON;
import com.Cory.JSON.JSONProvider;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
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


	
	// called everytime the widget updates which is every 30 minutes
	public void onUpdate (Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		
		newFileManager = new FileManager();
		
		// iterating through each addWidgetId
		final int N = appWidgetIds.length;
		for(int i = 0; i < N; i++){
		
			int appWidgetId = appWidgetIds[i];
			RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			
			appWidgetManager.updateAppWidget(appWidgetId, remoteView);
			
			// this is used to get the currency so that I can use it for another
			// json call
			if(newFileManager.readStringFile(context, fileName) != null){
				String jsonFile = newFileManager.readStringFile(context, fileName);
				
				// setting up my JSONObjects
				JSONObject jsonObject = null;
				JSONObject resultsObject = null;
				JSONObject currencyObject = null;
				
				try{
					
					// parsing out my json data
					jsonObject = new JSONObject(jsonFile);
					resultsObject = jsonObject.getJSONObject("bpi");
					
					amount = currencyObject.getString("rate").toString();
					
					// updating my widget
					//remoteView.setTextViewText(R.id.days_textview, amount);
					
				}catch(Exception e){
					
				}
				
				// updating my widget
				remoteView.setTextViewText(R.id.days_textview, amount);
			}

		}
		
		
		
	}
		
	
	
	public void onDelete(Context context, int[] appWidgetIds){
		
	}

	
	
}
