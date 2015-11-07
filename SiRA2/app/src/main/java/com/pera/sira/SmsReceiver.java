package com.pera.sira;

/**
 * Created by Ishan Madhusanka on 11/07/2015.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    private static final String TAG = SmsReceiver.class.getSimpleName();
    private String txtPhoneNo = "678";
    private String txtMessage = "MBB";
    private String city;
    public static Long lastGPSRequestTime;
    public static String lastGPSRequestNo;
    private smsNotification notify;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle pudsBundle = intent.getExtras();
        Object[] pdus = (Object[]) pudsBundle.get("pdus");
        SmsMessage messages = SmsMessage.createFromPdu((byte[]) pdus[0]);
        Log.i(TAG, messages.getMessageBody());
        String messageTxt = messages.getMessageBody();
        StringFinder sf=new StringFinder();
        String replyTxt = sf.find(messages.getMessageBody().toString());
        if(replyTxt.isEmpty()){
            return;
        }
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, 0);
        int ifSiRATurnedOn = sharedPref.getInt(context.getResources().getString(R.string.turned_on), 1);

// check if GPS enabled
//        GPSTracker gpsTracker = new GPSTracker(context);
//
//        if (gpsTracker.getIsGPSTrackingEnabled())
//        {
////            String stringLatitude = String.valueOf(gpsTracker.latitude);
////            textview = (TextView)findViewById(R.id.fieldLatitude);
////            textview.setText(stringLatitude);
////
////            String stringLongitude = String.valueOf(gpsTracker.longitude);
////            textview = (TextView)findViewById(R.id.fieldLongitude);
////            textview.setText(stringLongitude);
////
////            String country = gpsTracker.getCountryName(this);
////            textview = (TextView)findViewById(R.id.fieldCountry);
////            textview.setText(country);
//
//            city = gpsTracker.getLocality(context);
//
////            String postalCode = gpsTracker.getPostalCode(this);
////            textview = (TextView)findViewById(R.id.fieldPostalCode);
////            textview.setText(postalCode);
////
////            String addressLine = gpsTracker.getAddressLine(this);
////            textview = (TextView)findViewById(R.id.fieldAddressLine);
////            textview.setText(addressLine);
//        }
//        else
//        {
//            // can't get location
//            // GPS or Network is not enabled
//            // Ask user to enable GPS/network in settings
//            gpsTracker.showSettingsAlert();
//        }

//        if(messages.getMessageBody().contains("gm")) {
//            abortBroadcast();
//            Toast.makeText(context, messages.getMessageBody(),
//                    Toast.LENGTH_LONG).show();
//        }s


        if (ifSiRATurnedOn == 1) {
            if(replyTxt.equals("*")){
                lastGPSRequestTime=System.currentTimeMillis();
                lastGPSRequestNo=messages.getOriginatingAddress();
                GetLocation_1.is_LocationSent=false;
                GPStest gpstest=new GPStest(context);
                gpstest.onRequest();
                Log.d("GPS", "request sent");
            }
            else{
                sendSMSMessage(messages.getOriginatingAddress(), replyTxt);
                notify = new smsNotification(messages.getOriginatingAddress(), messageTxt, replyTxt);
                notify.smsNotify();
            }

       } else {
            Toast.makeText(context, "I should've said " + replyTxt, Toast.LENGTH_LONG).show();
        }
    }
    public static void sendSMSMessage(String txtPhoneNo, String txtMessage) {
        Log.i("Send SMS", "");
        Log.d(TAG, txtPhoneNo);
        String phoneNo = txtPhoneNo.toString();
        String message = txtMessage.toString();


        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            //Toast.makeText(context, "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            //Toast.makeText(context, "SMS failed, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}