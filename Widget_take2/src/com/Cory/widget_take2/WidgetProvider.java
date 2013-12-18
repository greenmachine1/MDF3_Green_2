package com.Cory.widget_take2;


import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider{

	
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
		}
		
	}
	
	public void onDelete(Context context, int[] appWidgetIds){
		
	}
	
	
}
