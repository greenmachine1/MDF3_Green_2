/*
 * Author: 			Cory Green
 * 
 * Project:			Widget_take2
 * 
 * Date:			Dec 19, 2013
 * 
 */
package com.Cory.widget_take2;



import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;

import com.Cory.JSON.FileManager;
import com.Cory.JSON.JSONProvider;
import com.Cory.JSON.WebInfo;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
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
	final String URI = "http://www.bitcoininformation.info";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		_context = this;
		
		// doing this so that ther is essentially a dummy file
		// instantiated from the get go
		JSONProvider jsonProvider = new JSONProvider();
		jsonProvider.returnJsonData("USD");
		
		
		FileManager newFileManager = new FileManager();
		newFileManager.writeStringFile(this, "JSON_file.txt", "file:///android_asset/JSON_file.txt");
		
		
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
