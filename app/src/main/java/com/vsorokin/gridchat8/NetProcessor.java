package com.vsorokin.gridchat8;

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
}
