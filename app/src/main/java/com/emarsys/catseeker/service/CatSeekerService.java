package com.emarsys.catseeker.service;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import com.emarsys.catseeker.network.NetworkClient;


public class CatSeekerService extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        if (sbn.getPackageName().equals("com.android.egg")) {
            NetworkClient.getInstance().postCatMessage("Hey guys, " + sbn.getNotification().extras.getString("android.text") + " is here. :cat:");
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
        if (sbn.getPackageName().equals("com.android.egg")) {
            NetworkClient.getInstance().postCatMessage(sbn.getNotification().extras.getString("android.text") + " has gone. :crying_cat_face:");
        }
    }
}
