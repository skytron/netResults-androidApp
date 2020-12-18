package com.skytron.netresultspushnotification.notification.helpers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.skytron.netresultspushnotification.R;


public class NotificationBuilderHelper {
    public static String TAG = NotificationTopicHelper.class.getSimpleName();

    private static NotificationBuilderHelper instance;

    private NotificationBuilderHelper() {
    }

    /**
     * Return singleton instance of class
     *
     * @return {@link NotificationBuilderHelper} Instance of {@link NotificationBuilderHelper}
     */
    public static NotificationBuilderHelper getInstance() {
        if (instance == null) {
            instance = new NotificationBuilderHelper();
        }

        return instance;
    }


}
