package com.vsorokin.gridchat8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button contacts;
    static NetProcessor netProcessor = new NetProcessor("ListView", "localId");

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

    }

}
