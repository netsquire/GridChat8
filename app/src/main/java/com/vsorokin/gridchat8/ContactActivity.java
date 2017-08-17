package com.vsorokin.gridchat8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    //ListView contactView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ScrollView contactView = (ScrollView) findViewById(R.id.contactView);
        View contacts = findViewById(R.id.contacts);
        contacts.setVerticalScrollBarEnabled(true);

        TextView header = new TextView(this);
        header.setText("HEADER");
        TextView footer = new TextView(this);
        footer.setText("FOOTER");
        contactView.addView(header);
        contactView.addView(footer);

        /*
        ListView listView = null;
        listView.addHeaderView(header);
        listView.addFooterView(footer);
        */
    }
}
