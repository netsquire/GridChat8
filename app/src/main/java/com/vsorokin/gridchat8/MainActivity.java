package com.vsorokin.gridchat8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.vsorokin.gridchat8.net.NetService;

public class MainActivity extends AppCompatActivity {

    public TextView selfName;
    public TextView peerName;
    public TextView selfIp;
    public TextView peerIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button letsGo;

        selfIp = findViewById(R.id.selfIp);
        peerIp = findViewById(R.id.peerIp);
        selfName = findViewById(R.id.selfName);
        selfName.setText(GridContext.getInstanceName());
        peerName = findViewById(R.id.peer);
        letsGo = findViewById(R.id.letsGo);

        NetService netService = new NetService();
        letsGo.setOnClickListener(v -> {
            GridContext.setInstanceName(selfName.getText().toString());
            GridContext.setPeerName(peerName.getText().toString());
            netService.announce();
            netService.getPeerAddress();
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
        });

    }

}
