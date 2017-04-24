package com.emarsys.catseeker;

import android.app.Application;
import android.content.Intent;

import com.emarsys.catseeker.network.ApiSecretProvider;
import com.emarsys.catseeker.service.CatSeekerService;

public class CatSeekerApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApiSecretProvider.init(this);
        startService(new Intent(this, CatSeekerService.class));
    }
}
