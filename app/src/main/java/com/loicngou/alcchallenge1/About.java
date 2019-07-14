package com.loicngou.alcchallenge1;

import android.app.ProgressDialog;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {

    TextView resume_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about2);
        resume_url = findViewById(R.id.resume);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("About this App ");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setElevation(1.2f);
        }

        resume_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebView webView = new WebView(getApplicationContext());
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                final ProgressDialog pd = new ProgressDialog(About.this);
                pd.setCancelable(false);
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
                webView.loadUrl("https://loicgeek.github.io");
                setContentView(webView);

            }
        });
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
