package com.pera.sira;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import static android.support.v4.app.NotificationCompat.Builder;
import static com.pera.sira.R.drawable.ic_launcher;

/**
 * Created by Rama on 11/7/2015.
 */
public class smsNotification extends Activity{
    private String number;
    private String recievedMsg;
    private String sentMsg;

    public smsNotification(String number, String recievedMsg, String sentMsg) {
        this.number = number;
        this.recievedMsg = recievedMsg;
        this.sentMsg = sentMsg;
    }
    public smsNotification(){

    }


    public void smsNotify(){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("SiRA")
                        .setContentText("SiRA has taken care of " + number + "\n" + "Received: " + recievedMsg + "\nSent: " + sentMsg);

        int mNotificationId = 001;
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
// mId allows you to update the notification later on.


}
