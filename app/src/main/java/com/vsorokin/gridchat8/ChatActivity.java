package com.vsorokin.gridchat8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


public class ChatActivity  extends AppCompatActivity {

    ListView messages;
    EditText message;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);
        Log.i("TAG", "started.");

        Personal personal = new Personal("000");
        List<String> contactList = new LinkedList<>();
        NetProcessor netProcessor = new NetProcessor("net processor", Personal.getId());
        button = (Button) findViewById(R.id.button);
        message = (EditText) findViewById(R.id.message);
        message.setText(netProcessor.getNetAddress());
        messages = (ListView) findViewById(R.id.Messages);

        //button.setOnClickListener(v -> messages.append("\r\n" + message.getEditableText()));
    }

}
