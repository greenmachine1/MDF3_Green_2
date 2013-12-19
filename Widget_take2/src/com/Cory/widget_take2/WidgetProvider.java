package com.Cory.widget_take2;


import com.Cory.JSON.FileManager;
import com.Cory.JSON.JSON;
import com.Cory.JSON.JSONProvider;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider{
	
	FileManager newFileManager;
	String fileName = "JSON_file.txt";


	
	// called everytime the widget updates which is every 30 minutes
	public void onUpdate (Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		
		newFileManager = new FileManager();
		
		// iterating through each addWidgetId
		final int N = appWidgetIds.length;
		for(int i = 0; i < N; i++){
		
			int appWidgetId = appWidgetIds[i];
			RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			
			// this will display the modified amount
			remoteView.setTextViewText(R.id.days_textview, "Yes!");
		
			appWidgetManager.updateAppWidget(appWidgetId, remoteView);
			
			// this is used to get the currency so that I can use it for another
			// json call
			if(newFileManager.readStringFile(context, "currency_origin.txt") != null){
				String currencyString = newFileManager.readStringFile(context, "currency_origin.txt");
				Log.i("thing", currencyString);
			}
			
			
			
			
			
			
			
		}
		
		
		
	}
	
	
	
	public void onDelete(Context context, int[] appWidgetIds){
		
	}

	
	
}
