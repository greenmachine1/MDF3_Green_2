package com.Cory.widget_take2;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RemoteViews;
import android.widget.RadioButton;

public class WidgetConfigActivity extends Activity implements OnClickListener{
	
	EditText userInput;
	Context _context;
	
	RadioGroup radioGroup1;
	RadioGroup radioGroup2;
	
	String currencySelected;
	String refreshRate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configure_main);
		// have to set R.layout.configure to configure_main
		
		
		_context = this;
		
		Button doneButton = (Button)this.findViewById(R.id.done_button);
		doneButton.setOnClickListener(this);

		// selecting my radiogroup1
		radioGroup1 = (RadioGroup)this.findViewById(R.id.currency_group);

	
	}

	// this is the done button 
	@Override
	public void onClick(View v) {
		
		// gathering the radio button input
		RadioButton selectedButton = (RadioButton)findViewById(radioGroup1.getCheckedRadioButtonId());
		
		currencySelected = selectedButton.getText().toString();

		
		
		Log.i("Button", selectedButton.getText().toString());

		
		// so basically what I need to do next, is 1). 
		// be able to access the api and pull info from it to the widget.
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			
			int widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, 
										 AppWidgetManager.INVALID_APPWIDGET_ID);
			
			// if we get a valid widgetID back then...
			if(widgetId != AppWidgetManager.INVALID_APPWIDGET_ID){

				
				// grabbing my widget text view and buttons
				RemoteViews remoteView = new RemoteViews(this.getPackageName(),R.layout.widget_layout);
				
				remoteView.setTextViewText(R.id.days_textview, currencySelected);

				AppWidgetManager.getInstance(this).updateAppWidget(widgetId, remoteView);
			
				
				Intent resultValue = new Intent();
				
				resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
				setResult(RESULT_OK, resultValue);
				
				
				finish();
				
				
				
				
			}
	
		}
				
	}

}
