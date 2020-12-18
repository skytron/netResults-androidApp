package com.skytron.netresultspushnotification.notification.service;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.skytron.netresultspushnotification.R;
import com.skytron.netresultspushnotification.activities.MainActivity;

import java.util.Date;
import java.util.Map;

/**
 * Class that handle push notification from FCM cloud messaging
 */
@SuppressLint("MissingFirebaseInstanceTokenRefresh")
public class PushNotificationService extends FirebaseMessagingService {
    private final String TAG = "PushNotificationService";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        final RemoteMessage.Notification notification = remoteMessage.getNotification();
        final Map<String, String>        data         = remoteMessage.getData();

        // Silent notification (data only)
        if (notification == null && data.size() > 0) {
            handleSilentNotificationDataOnly(data);
        } else if (notification != null) { // Default notification
            handleNotification(notification);
        }
    }

    /**
     * Handle silent notification (data only) from FCM
     * <p>
     * Start the main activity and show the message
     *
     * @param data {@link Map} A data from {@link RemoteMessage} object
     */
    private void handleSilentNotificationDataOnly(Map<String, String> data) {
        // Default message in case of notification data message is not present
        String message = getString(R.string.no_message_from_notification);
        if (data.containsKey("body")) {
            message = data.get("body");
        }

        // Prepare intent to start main activity with message from notification
        Intent startMainActivityIntent = makeMainActivityIntent(message);
        startActivity(startMainActivityIntent);

        // System logger
        Log.d(TAG, String.format("Silent notification with message %s received", message));
    }

    /**
     * Handle default notification FCM
     *
     * @param remoteNotification {@link RemoteMessage.Notification}
     */
    private void handleNotification(RemoteMessage.Notification remoteNotification) {
        String generalChannelId = getString(R.string.notification_channel_id);
        String title            = remoteNotification.getTitle();
        String message          = remoteNotification.getBody();

        // Create pending intent for notification action click
        Intent        startMainActivityIntent = makeMainActivityIntent(message);
        PendingIntent pendingIntent           = PendingIntent.getActivity(this, 0, startMainActivityIntent, 0);

        android.app.Notification notification = new NotificationCompat.Builder(this, generalChannelId)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        int                       notificationID            = generateUniqueNotificationID();
        notificationManagerCompat.notify(notificationID, notification);

        // System logger
        Log.d(TAG, String.format("Default notification with message %s received and showed", message));
    }

    /**
     * Make an intent to start main activity with extra data (body => message).
     * <p>
     * The message went from remote notification
     *
     * @param message {@link String} A message from push notification
     * @return {@link Intent}
     */
    private Intent makeMainActivityIntent(String message) {
        Intent startMainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
        startMainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startMainActivityIntent.setAction(Intent.ACTION_MAIN);
        startMainActivityIntent.putExtra("body", message);

        return startMainActivityIntent;
    }

    /**
     * Generate unique ID for notification.
     * <p>
     * Each notification must have a unique id to be shown separately from the others
     *
     * @return Unique ID
     */
    private int generateUniqueNotificationID() {
        // The generation of unique notification ID must be improved.
        // For the scope of this app, its enough
        long time = new Date().getTime();

        return (int) time;
    }
}
