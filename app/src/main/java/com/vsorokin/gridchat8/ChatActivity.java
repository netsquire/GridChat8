package com.vsorokin.gridchat8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        TextView tv = new TextView(this);
        Bundle extras = getIntent().getExtras();
        String name = null;
        if (extras != null) {
            name = extras.getString("name");
            }
        tv.setText("Hello, " + name);
        ll.addView(tv);
        setContentView(ll);
    }

}