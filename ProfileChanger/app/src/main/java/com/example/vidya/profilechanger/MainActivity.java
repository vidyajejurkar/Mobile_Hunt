package com.example.vidya.profilechanger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase SQLITEDATABASE;
    EditText trigger_word;
    TextView textView_hint;
    String sms;
    String SQLiteQuery;
    private boolean CheckEditTextEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_hint = (TextView) findViewById(R.id.textView_hint);
        Button button_ok = (Button) findViewById(R.id.button_ok);
        trigger_word = (EditText) findViewById(R.id.trigger_text);

        button_ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {

                SMSReciever.tempString = trigger_word.getText().toString();
                if (SMSReciever.tempString.equals("")) {
                    AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(MainActivity.this);
                    myAlertDialog.setTitle("Alert Message");
                    myAlertDialog.setMessage("You Need to select a Trigger Word.");
                    myAlertDialog.setIcon(R.drawable.activate);
                    myAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface myAlertDialog, int arg1) {
                            myAlertDialog.dismiss();
                        }
                    });
                    myAlertDialog.show();
                } else {
                    startActivity(new Intent(MainActivity.this, Alarm.class));
                }
                DBCreate();
                SubmitData2SQLiteDB();
            }
        });


    }

    public void DBCreate() {

        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);
        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS demoTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, sms VARCHAR);");
        System.out.println("database created suceesfully");
    }

    public void SubmitData2SQLiteDB() {

        sms = trigger_word.getText().toString();
        CheckEditTextIsEmptyOrNot(sms);
        if (CheckEditTextEmpty) {

            SQLiteQuery = "INSERT INTO demoTable (sms) VALUES('" + sms + ");";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(MainActivity.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

        } else {

            Toast.makeText(MainActivity.this, "Please Fill the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String sms) {

        if (TextUtils.isEmpty(sms)) {

            CheckEditTextEmpty = false;

        } else {
            CheckEditTextEmpty = true;
        }
    }

    public void ClearEditTextAfterDoneTask() {

        trigger_word.getText().clear();


    }


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


}
