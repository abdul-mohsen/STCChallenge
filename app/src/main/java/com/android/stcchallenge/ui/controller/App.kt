package com.android.stcchallenge.ui.controller

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.android.stcchallenge.BuildConfig
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}