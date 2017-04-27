package com.emarsys.catseeker.model

import android.app.Application
import android.content.pm.PackageManager

object MetaData {
    private val map: MutableMap<String, Any> = mutableMapOf()

    val apiSecret: String by map

    fun init(context: Application) {
        val metaData = context
                .packageManager
                .getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
                .metaData

        map.putAll(metaData.keySet()
                .associate { it to metaData[it] })
    }
}