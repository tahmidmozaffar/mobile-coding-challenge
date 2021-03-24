package com.app.unsplashgallery.repository

import com.app.unsplashgallery.ApiClient
import com.app.unsplashgallery.UnsplashImage
import com.app.unsplashgallery.runOnMainThread
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UnsplashRepository {

    fun getImages(
        onSuccess: (images: List<UnsplashImage>) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        GlobalScope.launch {

            try {
                val images = ApiClient().getPhotos()
                runOnMainThread {
                    onSuccess(images)
                }
            } catch (exp: Exception) {
                exp.printStackTrace()
                runOnMainThread { onFailure("Failed to fetch images") }
            }
        }
    }
}