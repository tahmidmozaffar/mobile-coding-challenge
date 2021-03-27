package com.app.unsplashgallery.domain.usecase.impl

import com.app.unsplashgallery.domain.usecase.UpdateScrollPositionUseCase

class UpdateScrollPositionUseCaseImpl(
    private val lastSelectedItem: Int?
) : UpdateScrollPositionUseCase {

    override fun shouldScrollToLastSelectedItem(): Boolean {
        if (lastSelectedItem == null || lastSelectedItem < 0) {
            return false
        }

        return true
    }
}