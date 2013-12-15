package com.Cory.week_3_stuff;


import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity{

	EditText textView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        */

        
        textView = (EditText)findViewById(R.id.editText1);
        
        Button goButton = (Button)findViewById(R.id.button1);
        goButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String textThatWasEntered = textView.getText().toString();
				Log.i("Text that was entered", textThatWasEntered);
				
				
				
				
			}
		});

    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	
    	switch (item.getItemId()){
    		
    	case R.id.first:
    		openFirst();
    		return true;
    	case R.id.second:
    		openSecond();
    		return true;
    	case R.id.third:
    		openThird();
    		return true;
    	default:
    		return super.onOptionsItemSelected(item);
    	
    	
    	}
    	
    }
    
    public void openFirst(){
    	Log.i("first", "selected");
    }
    
    public void openSecond(){
    	Log.i("second", "selected");
    }
    
    public void openThird(){
    	Log.i("third", "selected");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
