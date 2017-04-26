package com.emarsys.catseeker

import android.app.Application
import android.content.Intent
import com.emarsys.catseeker.service.CatSeekerService

class CatSeekerApp : Application() {

    companion object {
        lateinit var instance: CatSeekerApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startService(Intent(this, CatSeekerService::class.java))
    }
}