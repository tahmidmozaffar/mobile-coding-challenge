package com.app.unsplashgallery.data.source

import androidx.paging.PageKeyedDataSource
import com.app.unsplashgallery.util.Constants
import com.app.unsplashgallery.domain.model.UnsplashImage
import com.app.unsplashgallery.domain.repository.UnsplashRepository

class UnsplashImageDataSource(
    private val repository: UnsplashRepository
) : PageKeyedDataSource<Int, UnsplashImage>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, UnsplashImage>
    ) {
        repository.getImages(Constants.INITIAL_PAGE, Constants.IMAGE_PER_PAGE, onSuccess = {
            callback.onResult(it, null, Constants.INITIAL_PAGE + 1)
        }, onFailure = {
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UnsplashImage>) {
        repository.getImages(params.key, params.requestedLoadSize, onSuccess = {
            callback.onResult(it, params.key + 1)
        }, onFailure = {
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UnsplashImage>) {
    }

}