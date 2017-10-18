package com.vsorokin.gridchat8;

import static com.vsorokin.gridchat8.ContactActivity.adapter;
import static com.vsorokin.gridchat8.ContactActivity.contactList;

/**
 * Unites server and client
 *
 */
class NetProcessor extends Thread {

    private String netAddress;
    private AsyncClient asyncClient = new AsyncClient();
    private AsyncWebServer asyncServer = new AsyncWebServer();


    NetProcessor(String name, String id) {
        super(name);
        try {
            netAddress = new NetTask().execute().get();
        } catch (Exception e) {e.printStackTrace();}

        asyncServer.startServer();
        asyncClient.init(id, netAddress).start();
    }

    String getNetAddress() {
        return netAddress;
    }

/*    void listViewDemo(){

        try {
            Thread.sleep(2000);
            contactList.get(1).setActive(true);
            adapter.notifyDataSetChanged();

            Thread.sleep(2000);
            contactList.get(2).setAge(17);
            adapter.notifyDataSetChanged();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
