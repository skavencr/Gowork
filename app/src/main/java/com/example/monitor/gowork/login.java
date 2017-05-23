package com.example.monitor.gowork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class login extends AppCompatActivity {

    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void log (View v) {
        Intent i = new Intent(this, wvloger.class );
        startActivity(i);
    }

    public void reg (View v) {
        Intent i = new Intent(this, registro.class );
        startActivity(i);
    }

}
