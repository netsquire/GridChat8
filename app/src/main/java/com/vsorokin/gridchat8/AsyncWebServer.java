package com.vsorokin.gridchat8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.server.AsyncHttpServer;


public class AsyncWebServer extends AppCompatActivity {

    private AsyncHttpServer server = new AsyncHttpServer();
    private AsyncServer mAsyncServer = new AsyncServer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.i("TODO", " - onCreateOptionsMenu(Menu menu) launched.");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.i("TODO", " - onOptionsItemSelected(Menu menu) launched.");
        /*
        if (id == R.id.action_settings) {
            return true;
        }
        */
        //return super.onOptionsItemSelected(item);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        startServer();
    }

    void startServer() {
        server.get("/", (request, response) -> response.send("<h1>Hello!!!</h1>"));
        server.get("/info", (request, response) -> response.send("<h1>Info</h1>"));
        server.get("/m", (request, response) -> {
            Multimap query = request.getQuery();
            response.send("<h1>Got: " + query.entrySet().toString() + "</h1>");
        });
        server.listen(mAsyncServer, 8080);
    }
}


