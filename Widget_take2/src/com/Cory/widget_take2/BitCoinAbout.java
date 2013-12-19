package com.Cory.widget_take2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class BitCoinAbout extends Activity{

	final String URI = "http://www.bitcoininformation.info";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bitcoinabout);
		
		
		Intent newIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(this.URI));
		startActivity(newIntent);
		
		
	}
}
