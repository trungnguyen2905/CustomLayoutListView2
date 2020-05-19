package com.example.customlayoutlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebView_MonAn extends AppCompatActivity {

    WebView chiTietMonAn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view__mon_an);
        chiTietMonAn=findViewById(R.id.webview);
        intent=getIntent();
        String link=intent.getStringExtra("foodlink");
        chiTietMonAn.loadUrl(link);
        chiTietMonAn.setWebViewClient(new WebViewClient());
    }
}
