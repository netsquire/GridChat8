package com.vsorokin.gridchat8.net;

import android.os.AsyncTask;
import android.util.Log;

import com.vsorokin.gridchat8.AsyncClient;
import com.vsorokin.gridchat8.AsyncWebServer;
import com.vsorokin.gridchat8.GridContext;
import com.vsorokin.gridchat8.RouteInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

import java.util.Enumeration;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.vsorokin.gridchat8.Constants.LOCATOR_URL;

class NetTasks extends AsyncTask<String, Integer, RouteInfo> {

    private GridContext gridContext;
    private OkHttpClient httpClient = new OkHttpClient();

    private AsyncClient asyncClient = new AsyncClient();
    private final ThreadLocal<AsyncWebServer> asyncServer = new ThreadLocal<AsyncWebServer>() {
        @Override
        protected AsyncWebServer initialValue() {
            return new AsyncWebServer(gridContext);
        }
    };


    /**
     *
     * @return - required class object
     */
    AsyncTask getTask(String determinant){
        switch (determinant){
            //case : return new ObtainOwnIp();
              //  break;
        }
        return this;
    }


    NetTasks(GridContext context){
        gridContext = context;
    }

    @Override
    protected RouteInfo doInBackground(String... strings) {
        String answer = getJsonIp(gridContext.getPeerName());
        //asyncServer.get().startServer();
        Log.i("Passed name", gridContext.getInstanceName());
        Log.i("resolver answered", answer);
        asyncClient.init(gridContext.getInstanceName(), answer).start();
        String ip = null; //announceNetAddress(getAllIp(6));
        return new RouteInfo(answer, ip);
    }
/*
    public String getAllIp(int version) {
        String ipv4 = "?.?.?.?";
        String ipv6 = "?:?:?:?";
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface networkInterface = en.nextElement();
                Enumeration<InetAddress> addrs = networkInterface.getInetAddresses();
                while (addrs.hasMoreElements()){
                    InetAddress inetAddress = addrs.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        Log.i("IP", "HostAddress IP=" + inetAddress.getHostAddress());
                        if(inetAddress instanceof Inet4Address) {
                            ipv4 = inetAddress.getHostAddress();
                        }
                        if(inetAddress instanceof Inet6Address) {
                            ipv6 = inetAddress.getHostAddress().split("%")[0];
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return version == 4 ? ipv4 : ipv6;
    }*/

    private String announceNetAddress(String ip) {
        String url = buildAnnounceUrl(ip, gridContext.getInstanceName());
        //Log.i("requested: ", url);
        Request request = new Request.Builder().url(url).build();
        try {
            new OkHttpClient().newCall(request).execute();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String buildAnnounceUrl(String ip, String alias) {
        return LOCATOR_URL + alias + "/ip/" + ip;
    }

    private String buildGetIpUrl(String id) {
        return LOCATOR_URL + "/ip/" + id;
    }

    private String getJsonIp(String id){
        Request request = new Request
                .Builder()
                .url(buildGetIpUrl(id))
                .build();
        Response response;
        String jsonData = null;
        try {
            response = httpClient.newCall(request).execute();
            jsonData = response.body().string();
            Log.i("response", jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

}
