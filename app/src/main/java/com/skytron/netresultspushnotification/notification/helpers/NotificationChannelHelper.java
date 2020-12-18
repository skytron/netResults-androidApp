package com.skytron.netresultspushnotification.notification.helpers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import com.skytron.netresultspushnotification.R;

/**
 * Singleton class to channel notification Helper
 * <p>
 * Helper to create a specific channel notification
 */
public class NotificationChannelHelper {
    private static NotificationChannelHelper instance;

    private NotificationChannelHelper() {
    }

    /**
     * Return singleton instance of class
     *
     * @return {@link NotificationChannelHelper} Instance of {@link NotificationChannelHelper}
     */
    public static NotificationChannelHelper getInstance() {
        if (instance == null) {
            instance = new NotificationChannelHelper();
        }

        return instance;
    }

    /**
     * Create a general notification channel
     *
     * @param context {@link Context}
     */
    public void createGeneralChannel(Context context) {
        // Create a notification channel only on API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId   = context.getString(R.string.notification_channel_id);
            String channelName = context.getString(R.string.notification_channel_general_name);
            String description = context.getString(R.string.notification_channel_general_description);

            // Set importance to HIGH allows to show notification everywhere
            // with capability to sounds, vibrate
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, importance);
            notificationChannel.setDescription(description);

            // Create notification channel in system
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    /**
     * Create all notification channel
     *
     * @param context {@link Context}
     */
    public void createAllChannel(Context context) {
        // General channel
        createGeneralChannel(context);
    }
}
