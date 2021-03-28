package com.app.unsplashgallery.di.modules

import com.app.unsplashgallery.ui.SharedViewModel
import com.app.unsplashgallery.ui.imageGrid.GalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    single {
        SharedViewModel(get())
    }

    viewModel {
        GalleryViewModel()
    }
}