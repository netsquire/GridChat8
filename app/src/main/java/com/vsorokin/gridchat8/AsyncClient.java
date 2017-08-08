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
    private OkHttpClient client = new OkHttpClient();

    AsyncClient() {}

    AsyncClient init(String id, String localIp, List<String> contactList) {
        this.id = id;
        this.localIp = localIp;
        this.contactList = contactList;
        return this;
    }

    String getIpById(String id){
        String op = "/ip/";
        return getRequest(LOCATOR_URL, id, op, localIp);
    }

    private String getRequest(String url, String... params){
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response != null ? response.toString() : null;
    }

}
