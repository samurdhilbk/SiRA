package com.pera.sira;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.io.IOException;
import java.lang.String;


public class GPStest{

    private Button buttonname;
    private GetLocation_1 locationListener;
    private LocationManager locationManager;
    private  double lat;
    private  double lon;

    static Context mContext;
    public GPStest(Context mContext) {
        this.mContext = mContext;
    }

    public void onRequest() {
        locationManager = (LocationManager)mContext.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new GetLocation_1();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        Log.d("CLICK", "Button Clicked");
    }

    public static String displayAddress(double i_lat, double i_lon){
        Geocoder geo = new Geocoder(mContext);
        Log.d("GPSSSSSSSSS",i_lat+" "+i_lon);
        List<Address> myAddrs = new ArrayList<Address>();

        try {
            myAddrs = geo.getFromLocation(i_lat, i_lon, 1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.d("GEO", String.valueOf(myAddrs.get(0)));
        StringBuffer output = new StringBuffer("");


        for(int i = 0; i< myAddrs.get(0).getMaxAddressLineIndex(); i++){
            output.append( myAddrs.get(0).getAddressLine(i));
            output.append(", ");
        }
        output.append(myAddrs.get(0).getSubAdminArea());
        return output.toString();

    }
}
