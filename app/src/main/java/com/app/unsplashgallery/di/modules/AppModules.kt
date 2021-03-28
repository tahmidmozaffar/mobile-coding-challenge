package com.app.unsplashgallery.di.modules

import com.app.unsplashgallery.config.ConfigHelper
import com.app.unsplashgallery.config.ConfigHelperImpl
import com.app.unsplashgallery.domain.repository.UnsplashRepository
import com.app.unsplashgallery.domain.repository.UnsplashRepositoryImpl
import org.koin.dsl.module

val appModules = module {

    single<ConfigHelper> {
        ConfigHelperImpl(get())
    }

    single<UnsplashRepository> {
        UnsplashRepositoryImpl(get())
    }
}