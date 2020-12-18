package com.skytron.netresultspushnotification.application;

import android.app.Application;
import android.content.Context;

import com.skytron.netresultspushnotification.notification.helpers.NotificationChannelHelper;
import com.skytron.netresultspushnotification.notification.helpers.NotificationTopicHelper;

public class NetResultsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initApplication();
    }

    /**
     * Init application
     */
    private void initApplication() {
        Context context = getApplicationContext();

        // Create all notification channel
        NotificationChannelHelper.getInstance().createAllChannel(context);
        // Subscribe to all topics
        NotificationTopicHelper.getInstance().subscribeToAllTopics(context);
    }
}
