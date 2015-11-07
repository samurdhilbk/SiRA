package com.pera.sira;

import android.database.Cursor;
import android.provider.CalendarContract;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by samsung on 12-Jul-15.
 */
public class calenderChecker {

    private static Cursor mCursor;
    public calenderChecker() {

        MainActivity.manager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        mCursor=MainActivity.mCursor;
        //setContentView(R.layout.main);

    }

    public static String[] check() {
        String title="";
        Long start;
        Long end ;
        Long seconds;
        String[] whether ={"",""};


        while(!mCursor.isLast()) {
            mCursor.moveToNext();
            try {
                title=mCursor.getString(0);
                start = mCursor.getLong(1);
                end = mCursor.getLong(2);
                seconds = System.currentTimeMillis();
                if(seconds <= end && seconds >= start){
                 whether[0]=title;
                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
                    Date resultdate = new Date(seconds);
                    whether[1]=sdf.format(resultdate);
                }

            } catch (Exception e) {
                //ignore
            }
        }
        return whether;
    }

}
