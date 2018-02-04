package com.vsorokin.gridchat8.net;

import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.vsorokin.gridchat8.GridContext;
import com.vsorokin.gridchat8.services.UrlService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AnnounceOwnIp implements Runnable {

    private ObjectMapper om = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();
    private TypeReference<HashMap<String,String>> typeRef = new TypeReference<HashMap<String,String>>(){};

    private Map<String, String> announceNetAddress(String ip) {
        String url = UrlService.buildAnnounceUrl(ip, GridContext.getInstanceName());
        Log.i("URL", url);
        Map<String, String> map = null;
        Request request = new Request.Builder().url(url).build();
        try {
            String response = new OkHttpClient().newCall(request).execute().body().string();
            map = om.readValue(response, typeRef);
            for (String name : map.keySet()) {
                Log.i("("+name, map.get(name)+")");
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public void run() {
        GridContext.setPeerList(announceNetAddress(GridContext.getIp()));
    }
}
