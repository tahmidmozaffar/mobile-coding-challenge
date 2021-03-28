package com.app.unsplashgallery.ui

import android.app.Application
import com.app.unsplashgallery.di.modules.appModules
import com.app.unsplashgallery.di.modules.useCaseModules
import com.app.unsplashgallery.di.modules.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationObject : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationObject)
            modules(listOf(appModules, viewModelModules, useCaseModules))
        }
    }
}