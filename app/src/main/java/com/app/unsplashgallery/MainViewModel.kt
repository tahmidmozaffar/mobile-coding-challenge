package com.app.unsplashgallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.unsplashgallery.repository.UnsplashRepository

class MainViewModel : ViewModel() {

    var selectedItem: Int = 0

    val photosLiveData = MutableLiveData<List<UnsplashImage>>()


    fun loadImages() {
        val repository = UnsplashRepository()
        repository.getImages({
            photosLiveData.value = it
        }, {
            println(it)
        })

    }
}