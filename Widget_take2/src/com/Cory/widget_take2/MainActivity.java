package com.Cory.widget_take2;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


// this will house the main loading screen.
// it will have at least 2 called activities from the 
// action bar
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		
		
		
		
		
		
		
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
