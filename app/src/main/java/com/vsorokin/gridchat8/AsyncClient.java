package com.vsorokin.gridchat8;

import android.util.AndroidRuntimeException;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static com.vsorokin.gridchat8.Constants.LOCATOR_URL;

public class AsyncClient extends Thread {

    private HttpsURLConnection connection;
    private String id;
    private String localIp;
    private OkHttpClient client = new OkHttpClient();

    public AsyncClient() {}

    public AsyncClient init(String id, String localIp) {
        this.id = id;
        this.localIp = localIp;
        return this;
    }

    public void start(){
        super.start();
        announceIp(id);
    }

    private String announceIp(String id){
        return getRequest(LOCATOR_URL + id + "/ip/" + localIp);
    }

    private String getRequest(String url){
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException | AndroidRuntimeException arte) {
            //e.printStackTrace();
            Log.i("Android Runtime", arte.getMessage());
        }
        return response != null ? response.toString() : null;
    }

}
