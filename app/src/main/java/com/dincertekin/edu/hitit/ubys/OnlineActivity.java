package com.dincertekin.edu.hitit.ubys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class OnlineActivity extends AppCompatActivity {

    WebView webView;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);

        connect();
        load();
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.homepage);

        ColorStateList iconColorStates = new ColorStateList(
                new int[][] {
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[] {
                        Color.parseColor("#cccccc"),
                        Color.parseColor("#ffffff")
                }
        );

        navigationView.setItemIconTintList(iconColorStates);
        navigationView.setItemTextColor(iconColorStates);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homepage: {
                        startActivity(new Intent(getApplication(), OnlineActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    }
                    case R.id.announcements: {
                        startActivity(new Intent(getApplication(), Announcements.class));
                        overridePendingTransition(0, 0);
                        return true;
                    }
                    case R.id.mail: {
                        startActivity(new Intent(getApplication(), Mail.class));
                        overridePendingTransition(0, 0);
                        return true;
                    }
                    case R.id.ubys: {
                        startActivity(new Intent(getApplication(), UBYS.class));
                        overridePendingTransition(0, 0);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public void connect() {
        webView = findViewById(R.id.web);
    }

    public void load() {
        webView.loadUrl("https://hitit.edu.tr/");
        webView.getSettings().setJavaScriptEnabled(true);
    }
}