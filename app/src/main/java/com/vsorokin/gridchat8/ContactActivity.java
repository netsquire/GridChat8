package com.vsorokin.gridchat8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    static ArrayList<Contact> contactList = getContactList();
    static ContactAdapter adapter;

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

/*    public void onResume() {
        super.onResume();
        startActivity( new Intent(this, ContactActivity.class)  );
    }*/

    static ArrayList<Contact> getContactList() {
        ArrayList<Contact> retList = new ArrayList<>();
        retList.add(new Contact("name", "id", 27, true));
        retList.add(new Contact("name1", "pathos", 67, false));
        retList.add(new Contact("name2", "wife", 47, true));
        retList.add(new Contact("name3", "bro", 28, false));
        retList.add(new Contact("name4", "me", 23, true));
        return retList;
    }
}
