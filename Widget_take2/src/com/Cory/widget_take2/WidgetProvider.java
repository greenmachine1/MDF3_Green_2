package com.Cory.widget_take2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider{

	public void doSomething(){
		Log.i("Do Something", "Do something");
	}
	
	// called everytime the widget updates which is every 30 minutes
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		
		// iterating through each addWidgetId
		final int N = appWidgetIds.length;
		for(int i = 0; i < N; i++){
		
			int appWidgetId = appWidgetIds[i];
			RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			remoteView.setTextViewText(R.id.days_textview, "Yes!");
			
			Log.i("Fired", "Fired!");
		
			appWidgetManager.updateAppWidget(appWidgetId, remoteView);
		}
		
	}
	public void onReceive(){
		
	}
	
	public void onDelete(Context context, int[] appWidgetIds){
		
	}
	
	
}
