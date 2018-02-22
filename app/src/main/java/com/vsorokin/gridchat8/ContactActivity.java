package com.vsorokin.gridchat8;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.vsorokin.gridchat8.model.Contact;
import com.vsorokin.gridchat8.model.GridContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView contactListView = findViewById(R.id.activity_contact);
        contactListView.setAdapter(new ContactAdapter(getApplicationContext(), GridContext.getPeerList()));
        int[] colors = {0, 0xFFFF0000, 0};
        contactListView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        contactListView.setDividerHeight(1);
    }
}
