package com.vsorokin.gridchat8.net;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.TextView;

import com.vsorokin.gridchat8.AsyncClient;
import com.vsorokin.gridchat8.AsyncWebServer;
import com.vsorokin.gridchat8.GridContext;
import com.vsorokin.gridchat8.MainActivity;
import com.vsorokin.gridchat8.R;
import com.vsorokin.gridchat8.RouteInfo;
import com.vsorokin.gridchat8.services.UrlService;

import java.io.IOException;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TaskChain {

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private OkHttpClient httpClient = new OkHttpClient();

    private AsyncClient asyncClient = new AsyncClient();
    AsyncWebServer asyncWebServer = new AsyncWebServer();

    //ExecutorService executor = Executors.newWorkStealingPool();
    private Callable<Object> obtainOwnIp = Executors.callable(new ObtainOwnIp());
    private Callable<Object> announceOwnIp = Executors.callable(new AnnounceOwnIp());
    private Callable<Object> showOwnIp = Executors.callable(new ShowOwnIp());

    @RequiresApi(api = Build.VERSION_CODES.N)
    void runTasksList(Runnable... runnables) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture.runAsync(new ObtainOwnIp(), executor)
                .thenRun(new AnnounceOwnIp());
        executor.shutdown();
    }

    void init(){
        try {
            executor.submit( obtainOwnIp ).get();
            //executor.submit( showOwnIp ).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    void announceAddress(){
        try {
            executor.submit(announceOwnIp).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    void getPeerAddress(){
        try {
            executor.submit( new GetPeerAddress() ).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    void stop(){
        executor.shutdown();
    }

    private String getJsonIp(String id){
        Request request = new Request
                .Builder()
                .url(UrlService.buildGetIpUrl(id))
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

    class ShowOwnIp implements Runnable {
        @Override
        public void run() {
            //MainActivity.selfIp.setText(GridContext.getIp());
        }
    }

    class GetPeerAddress implements Runnable {

        private void getPeerAddress(String ip) {
            String url = UrlService.buildGetIpUrl(GridContext.getPeerName());
            Log.i("PEER URL", url);
            Request request = new Request.Builder().url(url).build();
            try {
                String response = new OkHttpClient().newCall(request).execute().body().string();
                Log.i("Peer Response: ", response);
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            getPeerAddress(GridContext.getIp());
        }
    }

}
