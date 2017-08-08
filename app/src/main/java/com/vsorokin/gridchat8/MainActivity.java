package com.vsorokin.gridchat8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView messages;
    EditText message;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG", "started.");

        Personal personal = new Personal("000");
        List<String> contactList = new LinkedList<>();
        NetProcessor netProcessor = new NetProcessor("net processor", personal.getId());
        button = (Button) findViewById(R.id.button);
        message = (EditText) findViewById(R.id.message);
        message.setText(netProcessor.getNetAddress());
        messages = (TextView) findViewById(R.id.Messages);
        button.setOnClickListener(v -> messages.append("\r\n" + message.getEditableText()));
    }
}
