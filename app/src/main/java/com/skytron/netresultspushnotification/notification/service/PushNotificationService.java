package com.skytron.netresultspushnotification.notification.service;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class PushNotificationService extends FirebaseMessagingService {
    private final String TAG = "PushNotificationService";


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        final Map<String, String> data = remoteMessage.getData();
        final RemoteMessage.Notification notification = remoteMessage.getNotification();
        int i = 0;

//        Intent startMainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
//        startMainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        startMainActivityIntent.setAction(Intent.ACTION_MAIN);
//        startMainActivityIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//        startMainActivityIntent.putExtra("title", "titolo");
//        startActivity(startMainActivityIntent);

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(launchIntent);

    }
}
