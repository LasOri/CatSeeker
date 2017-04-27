package com.emarsys.catseeker

import android.app.Application
import android.content.Intent
import com.emarsys.catseeker.model.MetaData
import com.emarsys.catseeker.service.CatSeekerService

class CatSeekerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MetaData.init(this)
        startService(Intent(this, CatSeekerService::class.java))
    }
}