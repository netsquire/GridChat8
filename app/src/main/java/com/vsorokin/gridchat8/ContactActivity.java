package com.vsorokin.gridchat8;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import static com.vsorokin.gridchat8.MainActivity.netProcessor;

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

        Button button = (Button) findViewById(R.id.start_monitor);
        button.setOnClickListener(view -> demoRadio());
    }

    void demoRadio(){
        RadioButton radio = (RadioButton) findViewById(R.id.monitor);
        radio.setChecked(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        radio.setChecked(false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        radio.setChecked(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        radio.setChecked(false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        radio.setChecked(true);
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
