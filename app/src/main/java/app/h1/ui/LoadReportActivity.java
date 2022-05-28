package app.h1.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import app.h1.R;
import app.h1.SplashActivity;

public class LoadReportActivity extends AppCompatActivity {

    Toolbar toolbar;

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_report);
        webView = findViewById(R.id.web_view);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


//        webView.setVerticalScrollBarEnabled(true);
//        webView.requestFocus();
//        webView.getSettings().setDefaultTextEncodingName("utf-8");
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("https://hackerone.com/hafiz-ng");
//
//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });



//        Intent i = getIntent();
//        String result = i.getStringExtra("report_id");
//        Toast.makeText(LoadReportActivity.this, "Report: " + result, Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_web, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.back) {
            if (webView.canGoBack()) {
                webView.goBack();

            } else if (item.getItemId() == R.id.forward) {
                if (webView.canGoForward()) {
                    webView.canGoForward();
                }
            }

        }

        return super.onOptionsItemSelected(item);
    }
}