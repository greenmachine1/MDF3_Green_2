package com.Cory.widget_take2;

import com.Cory.JSON.FileManager;
import com.Cory.JSON.JSON;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


// this will house the main loading screen.
// it will have at least 2 called activities from the 
// action bar
public class MainActivity extends Activity {
	
	Context _context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		_context = this;

		
		Button goButton = (Button)this.findViewById(R.id.main_Button);
		goButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

			
			}
		});
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	// method used to handle action bar selection
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		switch (item.getItemId()){
		case R.id.first:
			// do something here
			Log.i("First action bar selected", "True");
			return true;
		case R.id.about:
			// do something here
			Log.i("About action bar selected", "True");
			return true;
		default:
				return super.onOptionsItemSelected(item);
		}
		
	}

}
