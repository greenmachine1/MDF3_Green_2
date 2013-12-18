package com.Cory.widget_take2;


import com.Cory.JSON.FileManager;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider{
	FileManager newFileManager;

	
	// called everytime the widget updates which is every 30 minutes
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		
		
		// iterating through each addWidgetId
		final int N = appWidgetIds.length;
		for(int i = 0; i < N; i++){
		
			int appWidgetId = appWidgetIds[i];
			RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			
			// this will display the modified amount
			remoteView.setTextViewText(R.id.days_textview, "Yes!");
		
			appWidgetManager.updateAppWidget(appWidgetId, remoteView);
			
			// pulling the currency of origin so I can use it with my json data
			try{
				String currencyOrigin = newFileManager.readStringFile(context, "currency_origin.txt").toString();
				Log.i("currency", currencyOrigin);
			}catch(Exception e){
				//Log.e("error", e.getMessage().toString());
			}
			
			
			
		}
		
	}
	
	public void onDelete(Context context, int[] appWidgetIds){
		
	}

	
	
}
