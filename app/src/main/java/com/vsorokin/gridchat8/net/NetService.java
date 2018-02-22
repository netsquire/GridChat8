package com.vsorokin.gridchat8.net;

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
public class NetService extends Thread {

    private TaskChain chain = new TaskChain();

    private AsyncWebServer asyncServer = new AsyncWebServer();

    private AsyncClient asyncClient = new AsyncClient();

    public NetService() {
        chain.init();
    }

    public void announce(){
        chain.announceAddress();
    }

    public void getPeerAddress() {
        chain.getPeerAddress();
    }
}
