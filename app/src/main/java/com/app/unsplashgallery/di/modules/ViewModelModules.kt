package com.app.unsplashgallery.di.modules

import android.content.Context
import com.app.unsplashgallery.ConfigHelper
import com.app.unsplashgallery.ConfigHelperImpl
import com.app.unsplashgallery.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel {
        MainViewModel(
            provideConfigHelper(get())
        )
    }
}

private fun provideConfigHelper(context: Context): ConfigHelper {
    return ConfigHelperImpl(context)
}