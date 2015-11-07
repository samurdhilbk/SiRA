package com.pera.sira;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends Activity{

    public static AudioManager manager;
    public static Cursor mCursor = null;
    public static String userName = "";

    private static final String[] COLS = new String[]

            {CalendarContract.Events.TITLE, CalendarContract.Events.DTSTART, CalendarContract.Events.DTEND};

    private static final String TAG = SmsReceiver.class.getSimpleName();
    private String addressString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager=(AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);
        mCursor = getContentResolver().query(CalendarContract.Events.CONTENT_URI, COLS, null, null, null);

        mCursor.moveToFirst();

        calenderChecker cc=new calenderChecker();
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor editor = sharedPref.edit();

        int turned_on = sharedPref.getInt(getString(R.string.turned_on), 1);
        int calendar_on = sharedPref.getInt(getString(R.string.calendar_on), 1);
        int gps_on = sharedPref.getInt(getString(R.string.gps_on), 1);
        userName = sharedPref.getString("setting_userName", "User");
        String location = sharedPref.getString("setting_location", "Faculty");
        int delay = sharedPref.getInt("setting_delay", 5);

        Switch toggle_SIRA = (Switch) findViewById(R.id.switch1);
        toggle_SIRA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = sharedPref.edit();
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView);
                int value=0;

                if (isChecked) {
                    // The toggle is enabled
                    Log.d(TAG, "toggled to 1");
                    imageView1.setImageResource(R.drawable.icon_on);
                    value = 1;
                } else {
                    // The toggle is disabled
                    Log.d(TAG, "toggled to 0");
                    imageView1.setImageResource(R.drawable.icon_off);
                    value = 0;
                }
                editor.putInt(getString(R.string.turned_on), value);
                editor.commit();
            }
        });

        // GPS
        Switch toggle_GPS = (Switch) findViewById(R.id.switch2);
        toggle_GPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = sharedPref.edit();
                int value=0;

                if (isChecked) {
                    // The toggle is enabled
                    value = 1;
                } else {
                    // The toggle is disabled
                    value = 0;
                }

                editor.putInt(getString(R.string.gps_on), value);
                editor.commit();
            }
        });

        // Calendar
        Switch toggle_Calendar = (Switch) findViewById(R.id.switch2);
        toggle_Calendar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = sharedPref.edit();
                int value=0;

                if (isChecked) {
                    // The toggle is enabled
                    value = 1;
                } else {
                    // The toggle is disabled
                    value = 0;
                }

                editor.putInt(getString(R.string.calendar_on), value);
                editor.commit();
            }
        });

        //
        final EditText et_username = (EditText) findViewById(R.id.editText);
        et_username.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                // you can call or do what you want with your EditText here
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("setting_userName", et_username.getText().toString());
                editor.commit();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        //
        final EditText et_location = (EditText) findViewById(R.id.editText2);
        et_location.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                // you can call or do what you want with your EditText here
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("setting_location", et_location.getText().toString() );
                editor.commit();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToPremium(View view) {
        Intent intent = new Intent(this, PremiumActivity.class);
        startActivity(intent);
    public static String getUserName(){
        return userName;
    }

    public void goToSiRAContacts(View view) {
        Intent intent = new Intent(this, SiRAContacts.class);
        startActivity(intent);
    }

    }