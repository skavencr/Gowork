package com.example.monitor.gowork;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Created by monitor on 18/05/2017.
 */

public class perfil extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        WebView mWebView = (WebView) findViewById(R.id.wv);
        mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mWebView.setWebViewClient(new SSLTolerentWebViewClient());
        mWebView.loadUrl("https://gowork.es/site/profile");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setDatabaseEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setBuiltInZoomControls(true);



        FloatingActionButton x = (FloatingActionButton) findViewById(R.id.lanzapop);
        x.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                startActivity(new Intent(perfil.this, pop_up.class));

            }


        });

    }



        class SSLTolerentWebViewClient extends WebViewClient {
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors

        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);

        }



    }





}