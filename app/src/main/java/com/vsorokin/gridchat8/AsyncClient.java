package com.vsorokin.gridchat8;

import android.util.Log;
import java.io.IOException;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


class AsyncClient {

    private HttpsURLConnection connection;

    AsyncClient(String url) {
        Log.i("CLIENT", "Starting client ");
        Request request = new Request.Builder().url(url).build();
        Response response = null;

        //try {
            OkHttpClient client = new OkHttpClient();
            //response = client.newCall(request).execute();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        ResponseBody body = null;
        if (response != null) {
            body = response.body();
        }
        Log.i("CLIENT", "Got response: " + body);
        if (body != null) {
            body.close();
        }
    }
}
