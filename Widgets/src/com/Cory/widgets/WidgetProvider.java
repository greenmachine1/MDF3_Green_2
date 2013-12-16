package com.Cory.widgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider{
	
	
	
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		// gets called based on the refresh rate set in the widget_provider xml
		
		RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
		
		appWidgetManager.updateAppWidget(appWidgetIds, remoteView);
		
		
	}
	
	public void onDeleted(Context context, int[]appWidgetIds){
		
	}

}
