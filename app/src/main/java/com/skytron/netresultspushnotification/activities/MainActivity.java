package com.skytron.netresultspushnotification.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.skytron.netresultspushnotification.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAIN";
    private final String GENERAL_TOPIC = "general";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Subscribe to a general topic
        FirebaseMessaging.getInstance().subscribeToTopic(GENERAL_TOPIC)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.d(TAG, String.format("Subscription to %s succesful completed!", GENERAL_TOPIC));
                    }
                }
        );

        Bundle b = getIntent().getExtras();

        setContentView(R.layout.activity_main);
    }
}