package com.dincertekin.edu.hitit.ubys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OfflineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Lütfen internet bağlantınızı kontrol edin...");
    }
}