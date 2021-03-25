package com.app.unsplashgallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.app.unsplashgallery.repository.UnsplashRepository

class MainViewModel(configHelper: ConfigHelper) : ViewModel() {

    private val repository = UnsplashRepository(configHelper)
    var selectedItem: Int = 0
    var photosLiveData: LiveData<PagedList<UnsplashImage>>
    private val unsplashImageDataSourceFactory: UnsplashImageDataSourceFactory =
        UnsplashImageDataSourceFactory(repository)

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(Constants.IMAGE_PER_PAGE)
            .setInitialLoadSizeHint(Constants.IMAGE_PER_PAGE * 2)
            .setEnablePlaceholders(false)
            .build()
        photosLiveData = LivePagedListBuilder(unsplashImageDataSourceFactory, config).build()
    }
}