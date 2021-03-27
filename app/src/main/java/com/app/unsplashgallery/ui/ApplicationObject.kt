package com.app.unsplashgallery.ui

import android.app.Application
import com.app.unsplashgallery.di.modules.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationObject : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationObject)
            modules(listOf(viewModels))
        }
    }
}