package com.vsorokin.gridchat8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.server.AsyncHttpServer;

public class AsyncWebServer extends AppCompatActivity implements Runnable {

    private GridContext gridContext;
    private AsyncHttpServer server = new AsyncHttpServer();
    private AsyncServer mAsyncServer = new AsyncServer();

    public AsyncWebServer(GridContext context){
        gridContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        startServer();
    }

    public void startServer() {
        server.get("/", (request, response) -> response.send("<h1>Hello!!!</h1>"));

        server.get("/info", (request, response) -> response.send("<h1>Info</h1>"));

        server.get("/m", (request, response) -> {
            Multimap query = request.getQuery();
            response.send("<h1>Got: " + query.entrySet().toString() + "</h1>");
        });

        TextView message = findViewById(R.id.selfName); // TODO: REMOVE IT
        server.get("/msg", (request, response) -> {
            runOnUiThread(() -> {
                message.setText(message.getText() + " ooo ");
            });
            Log.d("OUT", "writing response...");
            response.send("<h1>Got: RADIO  " + message.getText() + " </h1>");
        });
        server.listen(mAsyncServer, 8080);
    }

    @Override
    public void run() {
        this.startServer();
    }
}


