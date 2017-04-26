package com.emarsys.catseeker.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.AppCompatActivity
import com.emarsys.catseeker.R
import com.emarsys.catseeker.network.NetworkClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (!isNotificationListenerServiceEnabled()) {
            startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
        }

        catsForLife.setOnClickListener {
            NetworkClient.postCatMessage("Cats for life!")
        }
    }

    private fun isNotificationListenerServiceEnabled() =
            NotificationManagerCompat
                    .getEnabledListenerPackages(applicationContext)
                    .contains(applicationContext.packageName)
}