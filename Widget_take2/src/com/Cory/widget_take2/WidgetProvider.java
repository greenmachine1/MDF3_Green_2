package com.Cory.widget_take2;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider{

	
	// called everytime the widget updates
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		
		RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
		remoteView.setTextViewText(R.id.days_textview, "Yes!");
		
		appWidgetManager.updateAppWidget(appWidgetIds, remoteView);
		
	}
	
	public void onDelete(Context context, int[] appWidgetIds){
		
	}
	
	
}
