package com.vsorokin.gridchat8.net;

import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsorokin.gridchat8.model.Contact;
import com.vsorokin.gridchat8.model.GridContext;
import com.vsorokin.gridchat8.services.UrlService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class AnnounceOwnIp implements Runnable {

    private ObjectMapper om = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();
    private TypeReference<LinkedList<Contact>> typeRef = new TypeReference<LinkedList<Contact>>(){};

    private List<Contact> announceNetAddress(String ip) {
        String url = UrlService.buildAnnounceUrl(ip, GridContext.getInstanceName());
        Log.i("URL", url);
        List<Contact> contactList = null;
        Request request = new Request.Builder().url(url).build();
        try {
            String response = new OkHttpClient().newCall(request).execute().body().string();
            Log.i("to JSON", response);
            contactList = om.readValue(response, typeRef);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return contactList;
    }

    @Override
    public void run() { GridContext.setPeerList(announceNetAddress(GridContext.getIp()));}
}
