/*
 * Author: 			Cory Green
 * 
 * Project:			Widget_take2
 * 
 * Date:			Dec 19, 2013
 * 
 */
package com.Cory.widget_take2;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;



// this will house the main loading screen.
// it will have at least 2 called activities from the 
// action bar
public class MainActivity extends Activity {
	
	Context _context;
	final String URI = "http://www.bitcoininformation.info";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		_context = this;

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

			// goes to the bitcoininfo website
			Intent newIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(this.URI));
			startActivity(newIntent);
			
			return true;
		case R.id.about:
			
			// calls on the About activity
			Intent about = new Intent(this, About.class);
			startActivity(about);
			
			return true;
		default:
				return super.onOptionsItemSelected(item);
		}
		
	}

}
