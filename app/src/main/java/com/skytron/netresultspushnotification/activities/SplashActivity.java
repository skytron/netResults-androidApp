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
        // Wait 2 seconds
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                // TODO - Resend bundle data to main activity
                Intent startMainActivityIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(startMainActivityIntent);

                // Terminate splash activity
                finish();
            }
        }, 2000);
    }
}
