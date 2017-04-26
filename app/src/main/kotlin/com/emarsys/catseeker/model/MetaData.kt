package com.emarsys.catseeker.model

import android.content.pm.PackageManager
import com.emarsys.catseeker.CatSeekerApp

object MetaData {
    private val map: MutableMap<String, Any> = mutableMapOf()
    val apiSecret: String by map

    init {
        val metaData = CatSeekerApp.instance
                .packageManager
                .getApplicationInfo(CatSeekerApp.instance.packageName, PackageManager.GET_META_DATA)
                .metaData
        metaData.keySet().forEach { key ->
            map[key] = metaData.get(key)
        }
    }
}