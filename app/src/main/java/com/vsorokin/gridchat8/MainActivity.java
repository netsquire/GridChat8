package com.vsorokin.gridchat8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.vsorokin.gridchat8.net.NetProcessor;
import com.vsorokin.gridchat8.net.ObtainOwnIp;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    GridContext gridContext = new GridContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Show must ", "go on!");

        Button letsGo;
        TextView selfName, peerName, selfIp, peerIp;

        selfIp = findViewById(R.id.selfIp);
        peerIp = findViewById(R.id.peerIp);
        selfName = findViewById(R.id.selfName);
        peerName = findViewById(R.id.peer);
        letsGo = findViewById(R.id.letsGo);
        //new NetProcessor(gridContext);

        letsGo.setOnClickListener(v -> {
            Intent intent = new Intent(this, ContactActivity.class);
            gridContext.setInstanceName(selfName.getText().toString());
            gridContext.setPeerName(peerName.getText().toString());

            startActivity(intent);
        });

        new ObtainOwnIp(selfIp);
    }

}
