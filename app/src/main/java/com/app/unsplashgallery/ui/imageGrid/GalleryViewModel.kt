package com.app.unsplashgallery.ui.imageGrid

import androidx.lifecycle.ViewModel
import com.app.unsplashgallery.domain.usecase.impl.UpdateScrollPositionUseCaseImpl

class GalleryViewModel : ViewModel() {

    fun updateScrollState(lastSelectedItem: Int?, view: GalleryView) {

        val updateScrollPositionUseCase = UpdateScrollPositionUseCaseImpl()

        if (updateScrollPositionUseCase.shouldScrollToLastSelectedItem(lastSelectedItem)) {
            view.scrollToLastSelectedItem()
        } else {
            view.restoreScrollPosition()
        }
    }
}