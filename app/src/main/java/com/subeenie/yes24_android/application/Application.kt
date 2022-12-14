package com.subeenie.yes24_android.application

import android.app.Application
import com.subeenie.yes24_android.BuildConfig
import timber.log.Timber

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}