package com.app.unsplashgallery.ui.imageGrid.pagingDataSource

import androidx.paging.PageKeyedDataSource
import com.app.unsplashgallery.util.Constants
import com.app.unsplashgallery.domain.model.UnsplashImage
import com.app.unsplashgallery.domain.usecase.FetchImageUseCase

class UnsplashImageDataSource(
    private val fetchImageUseCase: FetchImageUseCase
) : PageKeyedDataSource<Int, UnsplashImage>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, UnsplashImage>
    ) {
        fetchImageUseCase.fetch(
            Constants.INITIAL_PAGE,
            Constants.IMAGE_PER_PAGE,
            Constants.ORDER_BY,
            onSuccess = {
                callback.onResult(it, null, Constants.INITIAL_PAGE + 1)
            },
            onFailure = {
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UnsplashImage>) {
        fetchImageUseCase.fetch(
            params.key,
            params.requestedLoadSize,
            Constants.ORDER_BY,
            onSuccess = {
                callback.onResult(it, params.key + 1)
            },
            onFailure = {
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UnsplashImage>) {
    }

}