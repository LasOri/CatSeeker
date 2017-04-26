package com.emarsys.catseeker.service

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.emarsys.catseeker.network.NetworkClient

class CatSeekerService : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        if (sbn.packageName == "com.android.egg") {
            val notificationText = sbn.notification.extras.getString("android.text")
            NetworkClient.postCatMessage("Hey guys, $notificationText is here. :cat:")
        }
    }
}