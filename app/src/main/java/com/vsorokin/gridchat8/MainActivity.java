package com.vsorokin.gridchat8;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.vsorokin.gridchat8.net.NetProcessor;
import com.vsorokin.gridchat8.net.IpTask;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    GridContext gridContext = new GridContext();
    //static AsyncTask<Void, Void, Void> ipTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button letsGo;
        TextView selfName, peerName, selfIp, peerIp;

        selfIp = findViewById(R.id.selfIp);
        peerIp = findViewById(R.id.peerIp);
        selfName = findViewById(R.id.selfName);
        peerName = findViewById(R.id.peer);
        letsGo = findViewById(R.id.letsGo);

        //ipTask = new IpTask(selfIp);
        try {
            new IpTask(selfIp).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        letsGo.setOnClickListener(v -> {
            Intent intent = new Intent(this, ContactActivity.class);
            gridContext.setInstanceName(selfName.getText().toString());
            gridContext.setPeerName(peerName.getText().toString());
            new NetProcessor(gridContext);
            startActivity(intent);
        });
    }

}
