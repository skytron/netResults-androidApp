package com.skytron.netresultspushnotification.notification.helpers;

import android.content.Context;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;
import com.skytron.netresultspushnotification.R;

/**
 * Singleton class to topic notification Helper
 * <p>
 * Helper to subscribe/unsubscribe to specific and all topics
 */
public class NotificationTopicHelper {
    public static String TAG = NotificationTopicHelper.class.getSimpleName();

    private static NotificationTopicHelper instance;

    private NotificationTopicHelper() {
    }

    /**
     * Return singleton instance of class
     *
     * @return {@link NotificationTopicHelper} Instance of {@link NotificationTopicHelper}
     */
    public static NotificationTopicHelper getInstance() {
        if (instance == null) {
            instance = new NotificationTopicHelper();
        }

        return instance;
    }

    //region General Topic

    /**
     * Subscribe to general notification topic
     *
     * @param context {@link Context}
     */
    public void subscribeToGeneralTopic(Context context) {
        final String generalTopicName = context.getString(R.string.notification_general_topic);

        // Subscribe to a general topic
        FirebaseMessaging.getInstance()
                .subscribeToTopic(generalTopicName)
                .addOnCompleteListener(
                        task -> Log.d(TAG, String.format("Subscription to %s topic ended successfully", generalTopicName))
                )
                .addOnFailureListener(
                        task -> Log.e(TAG, String.format("Subscription to %s topic ended with failure", generalTopicName))
                );

    }

    /**
     * Unsubscribe to general notification topic
     *
     * @param context {@link Context}
     */
    public void unsubscribeToGeneralTopic(Context context) {
        final String generalTopicName = context.getString(R.string.notification_general_topic);

        // Subscribe to a general topic
        FirebaseMessaging.getInstance()
                .unsubscribeFromTopic(generalTopicName)
                .addOnCompleteListener(
                        task -> Log.d(TAG, String.format("Unsubscribe to %s topic ended successfully", generalTopicName))
                )
                .addOnFailureListener(
                        task -> Log.e(TAG, String.format("Unsubscribe to %s topic ended with failure", generalTopicName))
                );
    }
    //endregion

    //region All Topics
    /**
     * Subscribe to all notification topic
     *
     * @param context {@link Context}
     */
    public void subscribeToAllTopics(Context context) {

        // Subscribe to general topic
        subscribeToGeneralTopic(context);
    }

    /**
     * Unsubscribe to all notification topic
     *
     * @param context {@link Context}
     */
    public void unsubscribeToAllTopics(Context context) {

        // Subscribe to general topic
        unsubscribeToGeneralTopic(context);
    }
    //endregion
}
