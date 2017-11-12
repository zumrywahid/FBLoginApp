package com.appsgit.fbloginapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends Activity {

    CallbackManager callbackManager;

    LoginButton loginButton;

    AccessTokenTracker accessTokenTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.setReadPermissions("email");

        callbackManager = CallbackManager.Factory.create();

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Toast.makeText(MainActivity.this, "Successfuly logged in ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                // App code
                Toast.makeText(MainActivity.this, "Cancelled...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Toast.makeText(MainActivity.this, "Login error ", Toast.LENGTH_SHORT).show();
                exception.printStackTrace();
            }
        });
    }

    /*
    * It is must to forward the result to callbackmanager.
    * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
