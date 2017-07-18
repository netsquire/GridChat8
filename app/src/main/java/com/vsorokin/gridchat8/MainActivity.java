package com.vsorokin.gridchat8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView messages;
    EditText message;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG", "something happened.");

        button = (Button) findViewById(R.id.button);
        message = (EditText) findViewById(R.id.message);
        messages = (TextView) findViewById(R.id.Messages);

        button.setOnClickListener(v -> {
            String text = messages.getText().toString();
            messages.setText(text + "\r\n" + message.getEditableText());
        });

        new AsyncWebServer().startServer();
        String startUrl = "https://api.github.com/repos/square/okhttp/contributors";
        new AsyncClient(startUrl);
    }
}
