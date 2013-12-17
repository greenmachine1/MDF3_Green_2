package com.Cory.widget_take2;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

public class WidgetConfigActivity extends Activity implements OnClickListener{
	
	EditText userInput;
	Context _context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configure);
		
		_context = this;
		
		userInput = (EditText)this.findViewById(R.id.editText1);
		
		Button doneButton = (Button)this.findViewById(R.id.button1);
		doneButton.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			
			int widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, 
										 AppWidgetManager.INVALID_APPWIDGET_ID);
			
			// if we get a valid widgetID back then...
			if(widgetId != AppWidgetManager.INVALID_APPWIDGET_ID){
				
				// ... we send off the user input to the front end
				// of the widget.
				String userInputString = userInput.getText().toString();
				
				// grabbing my widget text view and buttons
				RemoteViews remoteView = new RemoteViews(this.getPackageName(),R.layout.widget_layout);
				
				remoteView.setTextViewText(R.id.days_textview, userInputString);
				
				AppWidgetManager.getInstance(this).updateAppWidget(widgetId, remoteView);
				
				Intent resultValue = new Intent();
				
				resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
				setResult(RESULT_OK, resultValue);
				finish();
				
				
				
				
			}
			
			
			
			
		}
		
		
		
		
		
	}
	

}
