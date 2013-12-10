package com.Cory.Treasure_Hunt;

import java.text.NumberFormat;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

// my project will consist of a few seperate things that meet the criteria
// for this weeks assignment.  I plan to make a sort-of treasure hunt style 
// game.  For now, the locations will be hard coded, but could eventually 
// be uploaded from an online database for users to go out and search for.

// going to be using location,
// network status,
// and audio playback for this project
public class MainActivity extends Activity implements LocationListener {

	LocationManager locationManager;
	TextView longitudeText;
	TextView latitudeText;
	
	TextView modifiedLat;
	TextView modifiedLong;
	
	TextView isInRoomText;
	TextView isInRoom2Text;
	
	NumberFormat format;
	
	float valueForLongitude;
	float valueForLatitude;
	
	float treasureValueForLongitude;
	float treasureValueForLatitude;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        format = NumberFormat.getNumberInstance();
        format.setMinimumFractionDigits(4);
        format.setMaximumFractionDigits(4);

        treasureValueForLatitude = 37.9837f;
        treasureValueForLongitude = -120.9837f;
        
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        
        longitudeText = (TextView)this.findViewById(R.id.longitude_text);
        latitudeText = (TextView)this.findViewById(R.id.latitude_text);
        
        modifiedLat = (TextView)this.findViewById(R.id.modified_lat);
        modifiedLong = (TextView)this.findViewById(R.id.modified_long);
        
        isInRoomText = (TextView)this.findViewById(R.id.is_in_room);
        isInRoom2Text = (TextView)this.findViewById(R.id.is_in_room2);
        
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

		
		// setting the formatting of the double floating points
		this.latitudeText.setText(format.format(location.getLatitude()));
		this.longitudeText.setText(format.format(location.getLongitude()));
		
		valueForLatitude = (Float.valueOf(format.format(location.getLatitude())));
		valueForLongitude = (Float.valueOf(format.format(location.getLongitude())));
		
		//Log.i("values", " " + valueForLatitude + " " + valueForLongitude + " " + treasureValueForLatitude + " " + treasureValueForLongitude);
		
		modifiedLat.setText("Init Lat: " +  valueForLatitude + " Treas Lat: " + treasureValueForLatitude);
		modifiedLong.setText("Init Long: " + valueForLongitude + " Treas Long: " + treasureValueForLongitude);
		
		
		// treasure value becomes 37.9838(up from 37.9837)
		if((treasureValueForLatitude + 0.0001f) < valueForLatitude){
			Log.i("greater than treasure value", "yes");
			isInRoomText.setText("is greater than lat treasure Value");
		}	
		// treasure value becomes 37.9836(down from 37.9837)
		else if((treasureValueForLatitude - 0.0001f) > valueForLatitude){
			Log.i("less than treasure value", "Yes");
			isInRoomText.setText("is Less than lat treasure Value");
		}
		// treaure value is the same as value
		else if(treasureValueForLatitude == valueForLatitude){
			Log.i("is equal to treasure value", "Yes");
			isInRoomText.setText("is equal to lat treasure Value");
		}
		
		if((treasureValueForLongitude + 0.0001f) > valueForLongitude){
			Log.i("greater than treasure value", "yes");
			isInRoom2Text.setText("is greater than long treasure value");
		}
		else if((treasureValueForLongitude - 0.0001f) < valueForLongitude){
			Log.i("Less than treasure value", "yes");
			isInRoom2Text.setText("is Less than long treasure value");
		}
		else if (treasureValueForLongitude == valueForLongitude){
			Log.i("Equal to treasure value", "yes");
			isInRoom2Text.setText("is Equal to long treasure value");
		}
		
		
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
