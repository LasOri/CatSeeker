package com.emarsys.catseeker.network;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;

public class ApiSecretProvider {
    public static final String TAG = "secretProvider";
    private static String secret;

    public static void init(Application app){
        try {
            secret = app.getPackageManager()
                    .getApplicationInfo(app.getPackageName(), PackageManager.GET_META_DATA)
                    .metaData
                    .getString("apiSecret");
        } catch (Exception e) {
            Log.e(TAG, "Failed to load meta-data, NameNotFound: " + e.getMessage());
            throw new IllegalStateException(e);
        }
    }

    public static String provideSecret() {
        return secret;
    }
}
