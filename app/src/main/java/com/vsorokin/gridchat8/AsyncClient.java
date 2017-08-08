package com.vsorokin.gridchat8;

import android.util.Log;
import java.io.IOException;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static com.vsorokin.gridchat8.Constants.LOCATOR_URL;

class AsyncClient extends Thread {

    private HttpsURLConnection connection;
    private String id;
    private String localIp;
    private List<String> contactList;

    AsyncClient() {}

    AsyncClient init(String id, String localIp, List<String> contactList) {
        this.id = id;
        this.localIp = localIp;
        this.contactList = contactList;
        return this;
    }

    public void start(){
        Log.i("CLIENT", "Starting client ");
        String announceUrl = LOCATOR_URL + id + "/ip/" + localIp;
        Request request = new Request.Builder().url(announceUrl).build();
        Response response = null;
        try {
            OkHttpClient client = new OkHttpClient();
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Log.i("CLIENT", "Got response: " + response);
    }

    String getIpById(String id){
        return null;
    }

    String get(String id){
        return null;
    }

}
