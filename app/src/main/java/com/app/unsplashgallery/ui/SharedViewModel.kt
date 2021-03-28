package com.app.unsplashgallery.ui

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.app.unsplashgallery.domain.model.UnsplashImage
import com.app.unsplashgallery.domain.repository.UnsplashRepository
import com.app.unsplashgallery.domain.usecase.FetchImageUseCase
import com.app.unsplashgallery.ui.imageGrid.pagingDataSource.UnsplashImageDataSourceFactory
import com.app.unsplashgallery.util.Constants
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

@KoinApiExtension
class SharedViewModel(repository: UnsplashRepository) : ViewModel(), KoinComponent {

    private val fetchImageUseCase: FetchImageUseCase by inject { parametersOf(repository) }
    private val unsplashImageDataSourceFactory: UnsplashImageDataSourceFactory =
        UnsplashImageDataSourceFactory(fetchImageUseCase)

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