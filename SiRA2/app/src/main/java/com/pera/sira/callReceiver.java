package com.pera.sira;

/**
 * Created by Ishan Madhusanka on 12/07/2015.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.preference.PreferenceManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * Created by samsung on 12-Jul-15.
 */
public class callReceiver extends BroadcastReceiver {

    public static boolean isCalendarProEnabled=false;
    private static final String TAG = "CustomPhoneStateListener";

    @Override
    public void onReceive(final Context context, Intent intent) {
        final TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        //Log.v(TAG,"inside");
        final AudioManager audio_mngr = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        telephony.listen(new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                //super.onCallStateChanged(state, incomingNumber);
                //audio_mngr .setRingerMode(AudioManager.RINGER_MODE_NORMAL);

                if (telephony.CALL_STATE_RINGING == state) {
                    // phone
                    //audio_mngr.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
                    int ifSiRATurnedOn = sharedPref.getInt(context.getResources().getString(R.string.turned_on), 1);

                    //Log.i(TAG, "RINGING, number: " + incomingNumber);
                    String[] response=calenderChecker.check();
                    String res;
                    if(isCalendarProEnabled){
                        res="I'm currently engaged in "+response[0]+". Please call me back after "+response[1];
                    }
                    else{
                        res="Sorry I'm busy right now. Please call me back later.";
                    }
                    if(!response.equals("")){
                       Log.i(TAG,"something");
                        if(ifSiRATurnedOn==1){
                            MainActivity.manager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                            SmsReceiver.sendSMSMessage(incomingNumber, res);
                        }
                        //setResultData(null);
                    }else{
                        Log.i(TAG, "");
                        int maxVolume=MainActivity.manager.getStreamMaxVolume(AudioManager.STREAM_RING);
                        MainActivity.manager.setStreamVolume(AudioManager.STREAM_RING, maxVolume, 0);
                        MainActivity.manager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    }
                }


            }
        }, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
