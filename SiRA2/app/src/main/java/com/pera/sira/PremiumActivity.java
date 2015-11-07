package com.pera.sira;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.pera.sira.IabHelper;

/**
 * Created by samsung on 06-Nov-15.
 */
public class PremiumActivity extends Activity {

    IabHelper mHelper;
    private Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium);
        String base64EncodedPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAz/Ln5+J1LoHH0C5b8Zc6tPl2OutgcCKfqAlQNVzSKffmmFhy7dkw8zdratDGmC9jEvRu8oVLH0KbXk2nuVCcTV3BmGtGotqpHcLvUFnef2lvSJCRqzbD/Ldk5C37nAosihHPZ9B7+lMdiPLR1pgwZZauQwcpDJ38S9S7Txv4HugSpRY4cGxxHIQwCppEvg2vji6OEIdBFE3g2I+I8XfIiAlRJ+F9jmeoRJsTGhim4ClAr+j2hq88RAr0aUyxt7gBTZLT6DQQtlloq1VH0VMXepi27U3lJp8zj5EDtLA2jTMeHoh1HSs2sXLPS9OGvRGEjve2DYJICQ0B7zYbBNCljwIDAQAB";

        // compute your public key and store it in base64EncodedPublicKey
        mHelper = new IabHelper(this, base64EncodedPublicKey);

        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {
                    // Oh noes, there was a problem.
                }
                // Hooray, IAB is fully set up!
            }
        });

        mySwitch = (Switch) findViewById(R.id.switch2);

        //set the switch to ON
        mySwitch.setChecked(true);

        //attach a listener to check for changes in sta
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    SmsReceiver.sendSMSMessage("77000", "SiRA");
                } else {

                }

            }

        });


        //check the current state before we display the screen
        if(mySwitch.isChecked()){

        }
        else {

        }

    }

    private void openAlert(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PremiumActivity.this);



        alertDialogBuilder.setTitle(this.getTitle()+ " decision");

        alertDialogBuilder.setMessage("Are you sure?");

        // set positive button: Yes message

        alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog,int id) {

                // go to a new activity of the app

                Intent positveActivity = new Intent(getApplicationContext(),

                        PositiveActivity.class);

                startActivity(positveActivity);

            }

        });

        // set negative button: No message

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog,int id) {

                // cancel the alert box and put a Toast to the user

                dialog.cancel();

                Toast.makeText(getApplicationContext(), "You chose a negative answer",

                        Toast.LENGTH_LONG).show();

            }

        });

        // set neutral button: Exit the app message

        alertDialogBuilder.setNeutralButton("Exit the app",new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog,int id) {

                // exit the app and go to the HOME

                PremiumActivity.this.finish();

            }

        });



        AlertDialog alertDialog = alertDialogBuilder.create();

        // show alert

        alertDialog.show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mHelper != null) mHelper.dispose();
        mHelper = null;
    }

}
