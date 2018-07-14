package com.example.noelbehailu.socketio_android_basicapp_multiroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.nkzawa.socketio.client.Socket;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private Socket socketapp;

    private EditText username;
    private Button sign_in_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SocketApp app = (SocketApp) getApplication();

        socketapp = app.getSocket();

        username = (EditText) findViewById(R.id.username);
        sign_in_button = (Button) findViewById(R.id.sign_in_button);

        sign_in_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        socketapp.connect();
        Constants.usernameName = username.getText().toString();
        startActivity(new Intent(this, MainActivity.class));
    }
}

