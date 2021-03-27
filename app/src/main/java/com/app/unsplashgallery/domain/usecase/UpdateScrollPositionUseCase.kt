package com.app.unsplashgallery.domain.usecase

class UpdateScrollPositionUseCase(private val lastSelectedItem: Int?) {

    fun shouldRestoreScrollPosition(): Boolean {
        return lastSelectedItem == null
    }
}