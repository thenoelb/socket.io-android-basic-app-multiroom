package com.example.noelbehailu.socketio_android_tutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.nkzawa.socketio.client.Socket;

public class MainActivity extends Activity implements View.OnClickListener {

    private Socket mSocket;
    private SocketApp socketApp;
    private Button sendButton;
    private String mUsername = "androidtestnb";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        socketApp = (SocketApp) getApplication();
        sendButton = (Button) findViewById(R.id.sendbutton);
        sendButton.setOnClickListener(this);
        mSocket = socketApp.getSocket();
        mSocket.connect();
        if (mSocket.connected()){
            Toast.makeText(MainActivity.this, mUsername+"Connected!", Toast.LENGTH_SHORT).show();
            mSocket.emit("connection", mSocket);
        }
    }

    @Override
    public void onClick(View view) {
        mSocket.emit("chat message", "this works!");
    }
}
