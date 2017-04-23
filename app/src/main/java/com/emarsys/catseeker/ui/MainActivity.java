package com.emarsys.catseeker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.emarsys.catseeker.R;
import com.emarsys.catseeker.network.NetworkClient;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button catsForLifeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isNotificationListenerServiceEnabled()) {
            startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        }
        catsForLifeButton = (Button) findViewById(R.id.action);

        catsForLifeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkClient.getInstance().postCatMessage("Cats for life!");
            }
        });
    }

    private boolean isNotificationListenerServiceEnabled() {
        Set<String> packageNames = NotificationManagerCompat.getEnabledListenerPackages(getApplicationContext());
        return packageNames.contains(getApplicationContext().getPackageName());
    }

}
