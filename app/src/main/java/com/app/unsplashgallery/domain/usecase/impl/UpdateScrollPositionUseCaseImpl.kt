package com.app.unsplashgallery.domain.usecase.impl

import com.app.unsplashgallery.domain.usecase.UpdateScrollPositionUseCase

class UpdateScrollPositionUseCaseImpl : UpdateScrollPositionUseCase {

    override fun shouldScrollToLastSelectedItem(lastSelectedItem: Int?): Boolean {
        if (lastSelectedItem == null || lastSelectedItem < 0) {
            return false
        }

        return true
    }
}