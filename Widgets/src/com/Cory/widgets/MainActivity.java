package com.Cory.widgets;

import android.os.Bundle;
import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

	EditText mainTextField;
	String tempTypedString;
	Context _context;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mainTextField = (EditText)this.findViewById(R.id.editText);
        
        _context = this;
        
        Button mainGoButton = (Button)this.findViewById(R.id.go_button);
        mainGoButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Bundle extras = getIntent().getExtras();
				
				if(extras != null){
					
					int widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
					if(widgetId != AppWidgetManager.INVALID_APPWIDGET_ID){
						
						// gather info here
						tempTypedString = mainTextField.getText().toString();
						Log.i("Tapped", tempTypedString);
						
						
						RemoteViews remoteView = new RemoteViews(_context.getPackageName(), R.layout.widget_layout);
						remoteView.setTextViewText(R.id.days_textview, tempTypedString);
						
						
						AppWidgetManager.getInstance(_context).updateAppWidget(widgetId, remoteView);
						
						Intent resultValue = new Intent();
						resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
						setResult(RESULT_OK, resultValue);
						finish();
						
					}
					
				}
				
				
				
				
			}
        	
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

