package com.vsorokin.gridchat8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class ContactActivity extends AppCompatActivity {

    static ArrayList<Contact> contactList = getContactList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView contactListView = findViewById(R.id.activity_contact);
        contactListView.setAdapter(new ContactAdapter(getApplicationContext(), contactList));
        int[] colors = {0, 0xFFFF0000, 0};
        contactListView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        contactListView.setDividerHeight(1);

        contactListView.setOnItemClickListener((a, v, position, id) -> {
            Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
            Intent intent = new Intent(this, ChatActivity.class);
            intent.putExtra("position", position);
            intent.putExtra("id", id);
            startActivity(intent);
        });
    }

    static ArrayList<Contact> getContactList() {
        ArrayList<Contact> retList = new ArrayList<>();
        Map<String, String> list = GridContext.getPeerList();
        for (String name : list.keySet()){
            retList.add(new Contact(name, list.get(name), 17, true));
        }
        return retList;
    }
}
