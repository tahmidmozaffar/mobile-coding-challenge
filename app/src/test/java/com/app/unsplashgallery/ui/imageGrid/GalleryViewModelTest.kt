package com.app.unsplashgallery.ui.imageGrid

import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito
import org.mockito.Mockito.times
import kotlin.text.Typography.times

class GalleryViewModelTest {

    private lateinit var galleryView: GalleryView
    private lateinit var viewModel: GalleryViewModel

    @Before
    fun setup() {
        galleryView = Mockito.mock(GalleryView::class.java)
        viewModel = GalleryViewModel()
    }

    @Test
    fun whenLastSelectedItem_is_null_scrollPositionWillBeRestore() {
        viewModel.updateScrollState(null, galleryView)
        Mockito.verify(galleryView, times(1)).restoreScrollPosition()
    }

    @Test
    fun whenLastSelectedItem_is_negativeNumber_scrollPositionWillBeRestore() {
        viewModel.updateScrollState(-1, galleryView)
        Mockito.verify(galleryView, times(1)).restoreScrollPosition()
    }

    @Test
    fun whenLastSelectedItem_is_zero_scrollTolastSelectedPosition_will_happen() {
        viewModel.updateScrollState(0, galleryView)
        Mockito.verify(galleryView, times(1)).scrollToLastSelectedItem()
    }

    @Test
    fun whenLastSelectedItem_is_greaterThanZero_scrollTolastSelectedPosition_will_happen() {
        viewModel.updateScrollState(2, galleryView)
        Mockito.verify(galleryView, times(1)).scrollToLastSelectedItem()
    }

    @After
    fun cleanup() {
        Mockito.reset(galleryView)
    }
}