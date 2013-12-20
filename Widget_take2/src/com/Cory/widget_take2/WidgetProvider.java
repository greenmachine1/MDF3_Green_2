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
			
			appWidgetManager.updateAppWidget(appWidgetId, remoteView);
			
			// I have this down below but it doesnt seem to be working
			// so to make this actually update, I have moved it to here
			// for demonstrative purposes.
			remoteView.setTextViewText(R.id.days_textview, "Update");
			
			Log.i("update called", "Yes");
			
			// this is used to get the currency so that I can use it for another
			// json call
			
			
		}

		}

		
	
	
	public void onDelete(Context context, int[] appWidgetIds){
		
	}

	

	
	
}

