package com.vsorokin.gridchat8.net;

import android.util.Log;

import com.vsorokin.gridchat8.GridContext;
import com.vsorokin.gridchat8.services.UrlService;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AnnounceOwnIp implements Runnable {

    private void announceNetAddress(String ip) {
        String url = UrlService.buildAnnounceUrl(ip, GridContext.getInstanceName());
        Log.i("URL", url);
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = new OkHttpClient().newCall(request).execute();
            System.out.println("Response: " + response);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        announceNetAddress(GridContext.getIp());
    }
}
