package com.dincertekin.edu.hitit.ubys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Announcements extends AppCompatActivity {

    WebView webView;
    BottomNavigationView navigationView;
    ListView listView;

    String universitySections[] = {
            "Alaca Avni Çelik Meslek Yüksekokulu",
            "İskilip Meslek Yüksekokulu",
            "Osmancık Ömer Derindere Meslek Yüksekokulu",
            "Sağlık Hizmetleri Meslek Yüksekokulu",
            "Sosyal Bilimler Meslek Yüksekokulu",
            "Sungurlu Meslek Yüksekokulu",
            "Teknik Bilimler Meslek Yüksekokulu"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        navigationView = findViewById(R.id.bottom_navigation);
        listView = findViewById(R.id.ulist);
        webView = findViewById(R.id.web);

        webView.setVisibility(View.INVISIBLE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });

        ArrayAdapter<String> usAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, universitySections);
        listView.setAdapter(usAdapter);
        listView.setOnItemClickListener(this::onItemClick);

        navigationView.setSelectedItemId(R.id.announcements);
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

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0: {
                listView.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
                String currentDate = new SimpleDateFormat("yyyy/M", Locale.getDefault()).format(new Date());
                webView.loadUrl("https://alacamyo.hitit.edu.tr/tr/arsiv/duyurular/"+currentDate);
                webView.getSettings().setJavaScriptEnabled(true);
                break;
            }
            case 1: {
                listView.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
                String currentDate = new SimpleDateFormat("yyyy/M", Locale.getDefault()).format(new Date());
                webView.loadUrl("https://iskilipmyo.hitit.edu.tr/tr/arsiv/duyurular/"+currentDate);
                webView.getSettings().setJavaScriptEnabled(true);
                break;
            }
            case 2: {
                listView.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
                String currentDate = new SimpleDateFormat("yyyy/M", Locale.getDefault()).format(new Date());
                webView.loadUrl("https://osmancikmyo.hitit.edu.tr/tr/arsiv/duyurular/"+currentDate);
                webView.getSettings().setJavaScriptEnabled(true);
                break;
            }
            case 3: {
                listView.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
                String currentDate = new SimpleDateFormat("yyyy/M", Locale.getDefault()).format(new Date());
                webView.loadUrl("https://shmyo.hitit.edu.tr/tr/arsiv/duyurular/"+currentDate);
                webView.getSettings().setJavaScriptEnabled(true);
                break;
            }
            case 4: {
                listView.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
                String currentDate = new SimpleDateFormat("yyyy/M", Locale.getDefault()).format(new Date());
                webView.loadUrl("https://sbmyo.hitit.edu.tr/tr/arsiv/duyurular/"+currentDate);
                webView.getSettings().setJavaScriptEnabled(true);
                break;
            }
            case 5: {
                listView.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
                String currentDate = new SimpleDateFormat("yyyy/M", Locale.getDefault()).format(new Date());
                webView.loadUrl("https://sungurlumyo.hitit.edu.tr/tr/arsiv/duyurular/"+currentDate);
                webView.getSettings().setJavaScriptEnabled(true);
                break;
            }
            case 6: {
                listView.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
                String currentDate = new SimpleDateFormat("yyyy/M", Locale.getDefault()).format(new Date());
                webView.loadUrl("https://tbmyo.hitit.edu.tr/tr/arsiv/duyurular/"+currentDate);
                webView.getSettings().setJavaScriptEnabled(true);
                break;
            }
        }
    }

}