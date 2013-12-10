package com.Cory.week_2_project;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

// my project will consist of a few seperate things that meet the criteria
// for this weeks assignment.  I plan to make a sort-of treasure hunt style 
// game.  For now, the locations will be hard coded, but could eventually 
// be uploaded from an online database for users to go out and search for.
public class MainActivity extends Activity implements LocationListener {

	LocationManager locationManager;
	TextView longitudeText;
	TextView latitudeText;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        
        longitudeText = (TextView)this.findViewById(R.id.longitude_text);
        latitudeText = (TextView)this.findViewById(R.id.latitude_text);
        
        String providerString = "gps";
        
        locationManager.requestLocationUpdates(providerString, 
        									   3*1000 /* msec */, 
        									   0 /* meters*/, 
        									   this);
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		String longitude = (String.valueOf(location.getLongitude()));
		String latitude = (String.valueOf(location.getLatitude()));
		
		this.latitudeText.setText(latitude);
		this.longitudeText.setText(longitude);
		
	}


	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
    
}
