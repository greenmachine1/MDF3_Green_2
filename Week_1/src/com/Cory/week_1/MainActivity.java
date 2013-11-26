package com.Cory.week_1;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // creates a uri number
        Uri number = Uri.parse("tel:2093523633");
        
        // creates an intent to DIAL a number
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        
        // starts the activity
        startActivity(callIntent);
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
