package com.loicngou.alcchallenge1;


import android.app.ProgressDialog;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

public class AboutACL extends AppCompatActivity {
    CircularProgressDrawable circularProgressDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        WebView webView = new WebView(getApplicationContext());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setTitle("loading...");
        pd.show();
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                System.out.println(error);
                handler.proceed();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if(pd.isShowing()){
                    pd.cancel();
                }
                super.onPageFinished(view, url);
            }
        });
        webView.loadUrl(getString(R.string.alc_website_url));
        setContentView(webView);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("ALC ");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setElevation(1.2f);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
