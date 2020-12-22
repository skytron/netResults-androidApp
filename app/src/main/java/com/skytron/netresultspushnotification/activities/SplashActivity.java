package com.skytron.netresultspushnotification.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.skytron.netresultspushnotification.R;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // Simulate loading data to show splash screen
        // Wait 1 second
        new Handler(Looper.getMainLooper()).postDelayed(() -> {

            // Resend intent extra from push notification
            Intent intent = getIntent();
            String body   = null;
            if (intent != null && intent.hasExtra("body")) {
                body = intent.getStringExtra("body");
            }

            Intent startMainActivityIntent = new Intent(SplashActivity.this, MainActivity.class);
            startMainActivityIntent.putExtra("body", body);
            startActivity(startMainActivityIntent);

            // Terminate splash activity
            finish();
        }, 1000);
    }
}
