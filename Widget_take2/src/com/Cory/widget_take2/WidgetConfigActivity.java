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
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RemoteViews;
import android.widget.RadioButton;

public class WidgetConfigActivity extends Activity implements OnClickListener{
	
	EditText userInput;
	Context _context;
	
	RadioGroup radioGroup1;
	RadioGroup radioGroup2;
	
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
		radioGroup2 = (RadioGroup)this.findViewById(R.id.refresh_rate_group);
		
		
		
		
	}

	// this is the done button 
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		RadioButton selectedButton = (RadioButton)findViewById(radioGroup1.getCheckedRadioButtonId());
		Log.i("Button", selectedButton.getText().toString());
		
		RadioButton selectedButtonAgain = (RadioButton)findViewById(radioGroup2.getCheckedRadioButtonId());
		Log.i("Button", selectedButtonAgain.getText().toString());
		
		
		
	}
	

	/*
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
	*/
	

}
