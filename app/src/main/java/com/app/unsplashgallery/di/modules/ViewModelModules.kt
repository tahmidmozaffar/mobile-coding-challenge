package com.app.unsplashgallery.di.modules

import android.content.Context
import com.app.unsplashgallery.config.ConfigHelper
import com.app.unsplashgallery.config.ConfigHelperImpl
import com.app.unsplashgallery.ui.MainViewModel
import com.app.unsplashgallery.ui.imageGrid.GalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel {
        MainViewModel(
            provideConfigHelper(get())
        )
    }
    viewModel {
        GalleryViewModel()
    }
}

private fun provideConfigHelper(context: Context): ConfigHelper {
    return ConfigHelperImpl(context)
}