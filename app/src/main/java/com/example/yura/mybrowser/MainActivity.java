package com.example.yura.mybrowser;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public class MyAppWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(Uri.parse(url).getHost().length() == 0) {
                return false;
            }

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;
        }

    }

    public void onClick(View view) {

        Intent intent= new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://developer.alexanderklimov.ru/android/"));
        startActivity(Intent.createChooser(intent, "Мяу..."));
/*
        Intent intent = new Intent("ru.alexanderklimov.Browser");
        intent.setData(Uri.parse("http://developer.alexanderklimov.ru/android/"));
        startActivity(intent);
*/

/*
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
*/
    }



}

