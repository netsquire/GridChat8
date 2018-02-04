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
    public TextView selfIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button letsGo;
        NetService netService = new NetService();
        selfIp = findViewById(R.id.selfIp);
        selfIp.setText(GridContext.getIp());

        selfName = findViewById(R.id.selfName);
        letsGo = findViewById(R.id.letsGo);

        letsGo.setOnClickListener(v -> {
            GridContext.setInstanceName(selfName.getText().toString());
            netService.announce();
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
        });

    }

}
