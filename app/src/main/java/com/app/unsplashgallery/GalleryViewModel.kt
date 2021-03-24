package com.app.unsplashgallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.unsplashgallery.repository.UnsplashRepository
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {
    val photosLiveData = MutableLiveData<List<UnsplashImage>>()

    fun loadImages() {
        val repository = UnsplashRepository()

        val images = repository.getImages({
            photosLiveData.value = it
        }, {
            println(it)
        })

    }

}