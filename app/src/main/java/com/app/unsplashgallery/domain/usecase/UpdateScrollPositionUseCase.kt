package com.app.unsplashgallery.domain.usecase

interface UpdateScrollPositionUseCase {
    fun shouldScrollToLastSelectedItem(): Boolean
}