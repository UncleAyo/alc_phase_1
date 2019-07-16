package com.example.alc4phase1;

import android.net.http.SslError;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Objects;

public class Main2Activity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);



        }
        webview = (WebView) findViewById(R.id.webedView);
        webview.setWebViewClient(new WvClient());
        webview.loadUrl("https://www.andela.com/alc/");
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        }
        private class WvClient extends WebViewClient {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError er) {
                handler.proceed();
                // Ignore SSL certificate errors
            }
        }

        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case android.R.id.home:
                    finish();
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }


        public boolean onCreateOptionsMenu (Menu menu){
            return true;
        }
        @Override
        public boolean onKeyDown ( int keyCode, KeyEvent event){
            // Check if the key event was the Back button and if there's history
            if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
                webview.goBack();
                return true;
            }
            // If it wasn't the Back key or there's no web page history, bubble up to the default
            // system behavior (probably exit the activity)
            return super.onKeyDown(keyCode, event);
        }


}
