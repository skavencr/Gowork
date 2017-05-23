package com.example.monitor.gowork;



import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class registro extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final WebView mWebView = (WebView) findViewById(R.id.wview5);
        mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
       // mWebView.setWebViewClient(new registro.SSLTolerentWebViewClient());
        mWebView.loadUrl("https://gowork.es/site/signup");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setDatabaseEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setBuiltInZoomControls(true);


// WebView settings
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);

// Load url
        mWebView.loadUrl("https://gowork.es/site/signup");

// Set WebViewClient to load the url in webview and not phone's default browser.

        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                String redirected = view.getUrl();
                redirected = Uri.decode(redirected);

                if (redirected.equals("https://gowork.es/site/profile")) {
                    mWebView.stopLoading();
                    Intent mIntent = new Intent(registro.this, MapsActivity.class);
                    startActivity(mIntent);
                }
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });


    //Esto es por si falla el certificado

      //  class SSLTolerentWebViewClient extends WebViewClient {
        //   public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        //       handler.proceed();
        //      final WebView mWebView = (WebView) findViewById(R.id.wview5);

            }
        }

