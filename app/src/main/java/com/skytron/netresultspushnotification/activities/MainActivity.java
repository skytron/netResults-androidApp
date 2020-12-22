package com.skytron.netresultspushnotification.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.skytron.netresultspushnotification.R;

public class MainActivity extends AppCompatActivity {
    private Toolbar  toolbar;
    private TextView notificationTextTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding ui
        toolbar            = findViewById(R.id.toolbar);
        notificationTextTV = findViewById(R.id.main_activity_notification_text);

        // Setup toolbar
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));

        // Check intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("body")) {
            String body   = intent.getStringExtra("body");

            if (body != null) {
                notificationTextTV.setText(body);
            }
        }
    }
}