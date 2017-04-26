package com.emarsys.catseeker.model

import android.content.pm.PackageManager
import com.emarsys.catseeker.CatSeekerApp

object MetaData {
    private val map: Map<String, Any> by lazy {
        val metaData = CatSeekerApp.instance
                .packageManager
                .getApplicationInfo(CatSeekerApp.instance.packageName, PackageManager.GET_META_DATA)
                .metaData

        metaData.keySet()
                .associate { it to metaData[it] }
    }

    val apiSecret: String by map
}