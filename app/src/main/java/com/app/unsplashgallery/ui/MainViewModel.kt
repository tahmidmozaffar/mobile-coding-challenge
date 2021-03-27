package com.app.unsplashgallery.ui

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.app.unsplashgallery.config.ConfigHelper
import com.app.unsplashgallery.domain.model.UnsplashImage
import com.app.unsplashgallery.domain.repository.UnsplashRepositoryImpl
import com.app.unsplashgallery.domain.usecase.impl.FetchImageUseCaseImpl
import com.app.unsplashgallery.ui.imageGrid.pagingDataSource.UnsplashImageDataSourceFactory
import com.app.unsplashgallery.util.Constants

class MainViewModel(configHelper: ConfigHelper) : ViewModel() {

    private val repository = UnsplashRepositoryImpl(configHelper)
    private val unsplashImageDataSourceFactory: UnsplashImageDataSourceFactory =
        UnsplashImageDataSourceFactory(FetchImageUseCaseImpl(repository))

    var selectedItem: Int? = null
    var scrollState: Parcelable? = null
    var photosLiveData: LiveData<PagedList<UnsplashImage>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(Constants.IMAGE_PER_PAGE)
            .setInitialLoadSizeHint(Constants.IMAGE_PER_PAGE * 2)
            .setEnablePlaceholders(false)
            .build()
        photosLiveData = LivePagedListBuilder(unsplashImageDataSourceFactory, config).build()
    }
}