package com.Cory.week_2_project;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

// my project will consist of a few seperate things that meet the criteria
// for this weeks assignment.  I plan to make a sort-of treasure hunt style 
// game.  For now, the locations will be hard coded, but could eventually 
// be uploaded from an online database for users to go out and search for.
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
