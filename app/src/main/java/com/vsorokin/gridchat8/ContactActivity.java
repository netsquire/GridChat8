package com.vsorokin.gridchat8;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    static ArrayList<Contact> contactList = getContactList();
    static ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView contactListView = (ListView) findViewById(R.id.contact_list);
        adapter = new ContactAdapter(this, contactList);
        contactListView.setAdapter(new ContactAdapter(this, contactList));
        contactListView.setOnItemClickListener((a, v, position, id) -> {
            Toast.makeText(getBaseContext(), "Hello", Toast.LENGTH_SHORT).show();
        });

        int[] colors = {0, 0xFFFF0000, 0};
        contactListView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        contactListView.setDividerHeight(1);
    }


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
