package com.app.unsplashgallery.ui.imageGrid

import androidx.lifecycle.ViewModel
import com.app.unsplashgallery.domain.usecase.UpdateScrollPositionUseCase

class GalleryViewModel : ViewModel() {

    fun updateScrollState(lastSelectedItem: Int?, view: GalleryView) {

        val updateScrollPositionUseCase = UpdateScrollPositionUseCase(lastSelectedItem)

        if (updateScrollPositionUseCase.shouldRestoreScrollPosition()) {
            view.restoreScrollPosition()
        } else {
            view.scrollToLastSelectedItem()
        }
    }
}