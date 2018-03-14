package com.vsorokin.gridchat8;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vsorokin.gridchat8.model.Contact;
import com.vsorokin.gridchat8.model.GridContext;
import com.vsorokin.gridchat8.net.AsyncClient;
import com.vsorokin.gridchat8.net.AsyncWebServer;

public class ChatActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        TextView tv = new TextView(this);
        Bundle extras = getIntent().getExtras();

        //System.out.println("EXTRAS: " + extras);
        Contact peer = null;
        if (extras != null) {
            peer = (Contact) extras.get("contact");
            }

            // add zero checks
        tv.setText("[" + GridContext.getInstanceName() + " <-> " + peer.getId() + "] ("
                + GridContext.getIp() + " <-> " + peer.getIp() + ")");

        // start WebSocket session here - connect()
        AsyncClient asyncClient = new AsyncClient();
        AsyncWebServer asyncWebServer = new AsyncWebServer();

        linearLayout.addView(tv);
        setContentView(linearLayout);
    }

}