package com.pera.sira;

import android.content.Context;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Ishan Madhusanka on 20/10/2015.
 */

public class GetLocation_1 implements LocationListener{

    public double lat = 0;
    public double lon = 0;
    private GPStest GPStestInstance;
    public Long lastUpdateTime;
    public static boolean is_LocationSent=false;

    @Override
    public void onLocationChanged(Location location) {
        Log.d("GPS", "location foundddddddddddd");
        lastUpdateTime= System.currentTimeMillis();
        lon = location.getLongitude();
        lat = location.getLatitude();
        Log.d("GPS", "location found");
        String myLocation = "Latitude = " + location.getLatitude() + " Longitude = " + location.getLongitude();

        //I make a log to see the results
        Log.e("MY CURRENT LOCATION", myLocation);

        if(!is_LocationSent&&Math.abs(lastUpdateTime-SmsReceiver.lastGPSRequestTime)<=180000){

            SmsReceiver.sendSMSMessage(SmsReceiver.lastGPSRequestNo,GPStest.displayAddress(lat, lon));
            is_LocationSent=true;
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

        Log.e("Status", "Changed");
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.e("Status", "Provider Enabled");
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.e("Status", "Provider Disabled");
    }
}
