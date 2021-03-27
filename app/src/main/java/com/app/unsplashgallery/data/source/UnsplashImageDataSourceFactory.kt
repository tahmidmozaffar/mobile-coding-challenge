package com.app.unsplashgallery.data.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.app.unsplashgallery.domain.model.UnsplashImage
import com.app.unsplashgallery.domain.repository.UnsplashRepository


class UnsplashImageDataSourceFactory(private val repository: UnsplashRepository) :
    DataSource.Factory<Int, UnsplashImage>() {

    val unsplashImageDataSourceLiveData = MutableLiveData<UnsplashImageDataSource>()

    override fun create(): DataSource<Int, UnsplashImage> {
        val unsplashImageDataSource = UnsplashImageDataSource(repository)
        unsplashImageDataSourceLiveData.postValue(unsplashImageDataSource)
        return unsplashImageDataSource
    }
}