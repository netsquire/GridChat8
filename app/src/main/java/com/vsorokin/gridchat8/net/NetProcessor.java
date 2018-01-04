package com.vsorokin.gridchat8.net;

import android.widget.TextView;

import com.vsorokin.gridchat8.AsyncClient;
import com.vsorokin.gridchat8.AsyncWebServer;
import com.vsorokin.gridchat8.GridContext;
import com.vsorokin.gridchat8.RouteInfo;
import com.vsorokin.gridchat8.net.NetTasks;

/**
 * Unites server and client
 *
 * 1) get known self (own) IP number
 * 2) get known name of instance
 * 3) start WS listener
 * 4) announce pair (own name : ip of listener) to router (route store)
 * 5) get known name of peer
 * 6) request IP of peer on router
 * 7) start WS client on IP of peer
 *
 */
public class NetProcessor extends Thread {

    private RouteInfo netAddress;
    private GridContext gridContext;
    private AsyncClient asyncClient = new AsyncClient();
    private AsyncWebServer asyncServer = new AsyncWebServer(gridContext);

    public NetProcessor(GridContext context) {
        super(context.getInstanceName());

        gridContext = context;
        getNetAddress();

        this.start();
    }

    public void getNetAddress() {
        try {
            netAddress = new NetTasks(gridContext).execute().get();
        } catch (Exception e) {e.printStackTrace();}
    }

    String setNetAddress(TextView addressField) {
        addressField.setText(this.netAddress.getId());
        return this.netAddress.getId();
    }


}
