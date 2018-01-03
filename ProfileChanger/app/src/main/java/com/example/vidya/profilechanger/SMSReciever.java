package com.example.vidya.profilechanger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Vidya on 12/14/2017.
 */


public class SMSReciever extends BroadcastReceiver {
    static final String ACTION =
            "android.provider.Telephony.SMS_RECEIVED";
    protected static final String NOTIFICATION_SERVICE = null;
    public static MediaPlayer mpStop;
    public static MediaPlayer mpStop1;
    public static String tempString = "";
    public static String message = "";


    @Override
    public void onReceive(Context context, Intent intent) {


        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;

        String str = "";

        if (bundle != null) {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i++) {
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                str += "SMS from " + msgs[i].getOriginatingAddress();
                str += " 8888410470";
                str += msgs[i].getMessageBody().toString();
                str += "\n";
                message = msgs[i].getMessageBody().toString();
            }
            if (message.equals(tempString)) {
                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();
                AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                if (Alarm.rb1.isChecked()) {
                    mpStop = MediaPlayer.create(context, R.raw.nice_sound);
                    mpStop.start();
                }
                if (Alarm.rb2.isChecked()) {
                    mpStop = MediaPlayer.create(context, R.raw.drop);
                    mpStop.start();
                }
                if (Alarm.rb3.isChecked()) {
                    mpStop = MediaPlayer.create(context, R.raw.lovely);
                    mpStop.start();
                }
                if (Alarm.rb4.isChecked()) {
                    mpStop = MediaPlayer.create(context, R.raw.magic);
                    mpStop.start();
                }
                if (Alarm.rb5.isChecked()) {
                    mpStop = MediaPlayer.create(context, R.raw.melody);
                    mpStop.start();
                }
                if (Alarm.rb6.isChecked()) {
                    mpStop = MediaPlayer.create(context, R.raw.hiphop);
                    mpStop.start();
                }
                new stop();
                Intent intent1 = new Intent(context, stop.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }

        }
        //---display the new SMS message---
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }


    private Context getApplicationContext() {
        // TODO Auto-generated method stub
        return null;
    }

    private void startActivity(Intent intent) {
        // TODO Auto-generated method stub

    }


}