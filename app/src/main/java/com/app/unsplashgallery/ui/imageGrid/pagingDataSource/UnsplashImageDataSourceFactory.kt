package com.app.unsplashgallery.ui.imageGrid.pagingDataSource

import androidx.paging.DataSource
import com.app.unsplashgallery.domain.model.UnsplashImage
import com.app.unsplashgallery.domain.usecase.FetchImageUseCase


class UnsplashImageDataSourceFactory(private val fetchImageUseCase: FetchImageUseCase) :
    DataSource.Factory<Int, UnsplashImage>() {

    override fun create(): DataSource<Int, UnsplashImage> {
        return UnsplashImageDataSource(fetchImageUseCase)
    }
}