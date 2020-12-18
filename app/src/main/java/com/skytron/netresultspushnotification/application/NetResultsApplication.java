package com.skytron.netresultspushnotification.application;

import android.app.Application;

import com.skytron.netresultspushnotification.notification.helpers.NotificationChannelHelper;

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
        // Create all notification channel
        NotificationChannelHelper.getInstance().createAllChannel(getApplicationContext());
    }
}
