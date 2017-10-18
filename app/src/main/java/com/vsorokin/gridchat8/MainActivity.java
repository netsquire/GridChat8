package com.vsorokin.gridchat8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button contacts;
    NetProcessor netProcessor = new NetProcessor("ListView", "localId");

    static RadioButton radioMonitor;
    static TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("NET", "started.");
        netProcessor.start();

        contacts = (Button) findViewById(R.id.contacts);
        contacts.setOnClickListener(v -> {
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
        });

        radioMonitor = (RadioButton) findViewById(R.id.monitor);
        message = (TextView) findViewById(R.id.message);
    }

    public static void output(String text){
        message.setText(message.getText().toString() + "\n\n" + text);
    }

}
