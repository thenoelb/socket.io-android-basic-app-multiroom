package com.example.noelbehailu.socketio_android_basicapp_multiroom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.nkzawa.socketio.client.Socket;

public class MainActivity extends Activity implements View.OnClickListener {

    private Socket mSocket;
    private SocketApp socketApp;
    private Button sendButton;
    private String mUsername = "androidtestnb";
    private String mRoom = "mobileTestRoom";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        socketApp = (SocketApp) getApplication();
        sendButton = (Button) findViewById(R.id.sendbutton);
        mSocket = socketApp.getSocket();
        mSocket.connect();
        mSocket.emit("room name", mRoom, mUsername);
        sendButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mSocket.emit("chat message", "this works!");

    }
}
