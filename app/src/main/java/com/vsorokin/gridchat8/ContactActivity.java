package com.vsorokin.gridchat8;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.vsorokin.gridchat8.model.Contact;
import com.vsorokin.gridchat8.model.GridContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView contactListView = findViewById(R.id.activity_contact);
        List<Contact> peerList = onlyPeers(GridContext.getPeerList());
        Log.i("peerList=", peerList.toString());
        contactListView.setAdapter(new ContactAdapter(getApplicationContext(), peerList));
        int[] colors = {0, 0xFFFF0000, 0};
        contactListView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        contactListView.setDividerHeight(1);
    }

    private List<Contact> onlyPeers(List<Contact> peerList) {
        List<Contact> peers = new LinkedList<>();
        peerList.forEach(contact -> {
            if (!contact.getId().equals(GridContext.getInstanceName())) {
                peers.add(contact);
            }
        });
        return peers;
    }
}
