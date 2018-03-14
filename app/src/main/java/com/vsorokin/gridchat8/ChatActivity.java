package com.vsorokin.gridchat8;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vsorokin.gridchat8.model.Contact;

public class ChatActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        TextView tv = new TextView(this);
        Bundle extras = getIntent().getExtras();

        System.out.println("EXTRAS: " + extras);
        Contact peer = null;
        if (extras != null) {
            peer = (Contact) extras.get("contact");
            }
            // add zero checks
        tv.setText("Hello, " + peer.getId() + " with " + peer.getIp());
        linearLayout.addView(tv);
        setContentView(linearLayout);
    }

}