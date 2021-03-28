package com.app.unsplashgallery.di.modules

import com.app.unsplashgallery.domain.usecase.FetchImageUseCase
import com.app.unsplashgallery.domain.usecase.UpdateScrollPositionUseCase
import com.app.unsplashgallery.domain.usecase.impl.FetchImageUseCaseImpl
import com.app.unsplashgallery.domain.usecase.impl.UpdateScrollPositionUseCaseImpl
import org.koin.dsl.module

val useCaseModules = module {
    single<FetchImageUseCase> {
        FetchImageUseCaseImpl(get())
    }

    single<UpdateScrollPositionUseCase> {
        UpdateScrollPositionUseCaseImpl()
    }
}