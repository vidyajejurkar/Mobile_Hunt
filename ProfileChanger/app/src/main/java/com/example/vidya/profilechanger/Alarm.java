package com.example.vidya.profilechanger;

import android.content.ContentValues;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.io.File;

public class Alarm extends Activity {

    Button ok = null;
    Button cancel = null;
    Button add = null;
    public static RadioButton rb1 = null;
    public static RadioButton rb2 = null;
    public static RadioButton rb3 = null;
    public static RadioButton rb4 = null;
    public static RadioButton rb5 = null;
    public static RadioButton rb6 = null;

    static MediaPlayer mp1 = new MediaPlayer();
    MediaPlayer mp2 = new MediaPlayer();
    MediaPlayer mp3 = new MediaPlayer();
    MediaPlayer mp4 = new MediaPlayer();
    MediaPlayer mp5 = new MediaPlayer();
    MediaPlayer mp6 = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);
        ok = (Button) findViewById(R.id.ok);
        cancel = (Button) findViewById(R.id.cancel);
        add = (Button) findViewById(R.id.add);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        rb5 = (RadioButton) findViewById(R.id.radioButton5);
        rb6 = (RadioButton) findViewById(R.id.radioButton6);

        rb1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (rb1.isChecked()) {
                    mp2.stop();
                    mp3.stop();
                    mp4.stop();
                    mp5.stop();
                    mp6.stop();
                    mp1 = MediaPlayer.create(Alarm.this, R.raw.nice_sound);
                    mp1.start();

                    Toast.makeText(Alarm.this, "Alarm1 is selected", Toast.LENGTH_SHORT).show();


                }


            }
        });

        rb2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (rb2.isChecked()) {
                    mp1.stop();
                    mp3.stop();
                    mp4.stop();
                    mp5.stop();
                    mp6.stop();

                    mp2 = MediaPlayer.create(Alarm.this, R.raw.drop);
                    mp2.start();

                    Toast.makeText(Alarm.this, "Alarm2 is selected", Toast.LENGTH_SHORT).show();

                }

            }
        });

        rb3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (rb3.isChecked()) {
                    mp1.stop();
                    mp2.stop();
                    mp4.stop();
                    mp5.stop();
                    mp6.stop();
                    mp3 = MediaPlayer.create(Alarm.this, R.raw.lovely);
                    mp3.start();

                    Toast.makeText(Alarm.this, "Alarm3 is selected", Toast.LENGTH_SHORT).show();

                }

            }
        });

        rb4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (rb4.isChecked()) {
                    mp1.stop();
                    mp2.stop();
                    mp3.stop();
                    mp5.stop();
                    mp6.stop();
                    mp4 = MediaPlayer.create(Alarm.this, R.raw.magic);
                    mp4.start();

                    Toast.makeText(Alarm.this, "Alarm4 is selected", Toast.LENGTH_SHORT).show();

                }

            }
        });

        rb5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (rb5.isChecked()) {
                    mp1.stop();
                    mp2.stop();
                    mp3.stop();
                    mp4.stop();
                    mp6.stop();
                    mp5 = MediaPlayer.create(Alarm.this, R.raw.melody);
                    mp5.start();

                    Toast.makeText(Alarm.this, "Alarm5 is selected", Toast.LENGTH_SHORT).show();

                }

            }
        });

        rb6.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (rb6.isChecked()) {
                    mp1.stop();
                    mp2.stop();
                    mp3.stop();
                    mp4.stop();
                    mp5.stop();
                    mp6 = MediaPlayer.create(Alarm.this, R.raw.hiphop);
                    mp6.start();

                    Toast.makeText(Alarm.this, "Alarm6 is selected", Toast.LENGTH_SHORT).show();

                }

            }
        });




        add.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("add alarm from sd card");
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_GET_CONTENT);
                intent1.setType("audio/*");
                startActivityForResult(
                        Intent.createChooser(intent1, "Choose Sound File"), 6);
            }
        });
        ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (rb1.isChecked()) {
                    mp1.stop();
                } else if (rb2.isChecked()) {
                    mp2.stop();
                } else if (rb3.isChecked()) {
                    mp3.stop();
                } else if (rb4.isChecked()) {
                    mp4.stop();
                } else if (rb5.isChecked()) {
                    mp5.stop();
                } else if (rb6.isChecked()) {
                    mp6.stop();
                }/* else {
                    AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(Alarm.this);
                    myAlertDialog.setTitle("Alert Message");
                    myAlertDialog.setMessage("You Need to select a Ringtone.");
                    myAlertDialog.setIcon(R.drawable.ring1);
                    myAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface myAlertDialog, int arg1) {
                            myAlertDialog.dismiss();
                        }
                    });
                    myAlertDialog.show();
                }*/
            }

        });
        cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder myAlertDialog1 = new AlertDialog.Builder(Alarm.this);
                myAlertDialog1.setTitle("Alert Message");
                myAlertDialog1.setMessage("Are You Sure You Want to canel? ");
                myAlertDialog1.setIcon(R.drawable.question1);
                myAlertDialog1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface myAlertDialog1, int arg1) {
                        Alarm.this.finish();
                    }
                });
                myAlertDialog1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface myAlertDialog1, int arg1) {
                        myAlertDialog1.cancel();
                    }
                });


                myAlertDialog1.show();
            }

        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 6) {
            Uri i = data.getData();  // getData
            String s = i.getPath(); // getPath
            File k = new File(s);  // set File from path
            if (s != null) {      // file.exists

                ContentValues values = new ContentValues();
                values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
                values.put(MediaStore.MediaColumns.TITLE, "ring");
                values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mp3");
                values.put(MediaStore.MediaColumns.SIZE, k.length());
                values.put(MediaStore.Audio.Media.ARTIST, R.string.app_name);
                values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
                values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
                values.put(MediaStore.Audio.Media.IS_ALARM, true);
                values.put(MediaStore.Audio.Media.IS_MUSIC, false);

                Uri uri = MediaStore.Audio.Media.getContentUriForPath(k
                        .getAbsolutePath());
                getContentResolver().delete(
                        uri,
                        MediaStore.MediaColumns.DATA + "=\""
                                + k.getAbsolutePath() + "\"", null);
                Uri newUri = getContentResolver().insert(uri, values);

                try {
                    RingtoneManager.setActualDefaultRingtoneUri(
                            Alarm.this, RingtoneManager.TYPE_RINGTONE,
                            newUri);
                } catch (Throwable t) {

                }
            }
        }
    }

}
