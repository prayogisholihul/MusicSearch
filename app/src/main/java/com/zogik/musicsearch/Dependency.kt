package com.zogik.musicsearch

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Dependency : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: Dependency
            private set
    }
}
