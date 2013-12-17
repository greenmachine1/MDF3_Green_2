package com.Cory.widget_take2;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider{

	
	// called everytime the widget updates
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		
		final int N = appWidgetIds.length;
		
		Log.i("Length", "" + N);
		
		for(int i = 0; i < N; i++){
		
			int appWidgetId = appWidgetIds[i];
			RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			remoteView.setTextViewText(R.id.days_textview, "Yes!");
		
		
			Log.i("Updated", "Yes");
		
			appWidgetManager.updateAppWidget(appWidgetId, remoteView);
		}
		
	}
	
	public void onDelete(Context context, int[] appWidgetIds){
		
	}
	
	
}
