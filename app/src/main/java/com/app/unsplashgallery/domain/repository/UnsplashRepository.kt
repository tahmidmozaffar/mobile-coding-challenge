package com.app.unsplashgallery.domain.repository

import com.app.unsplashgallery.config.ConfigHelper
import com.app.unsplashgallery.data.source.remote.ApiClient
import com.app.unsplashgallery.domain.model.UnsplashImage
import com.app.unsplashgallery.util.Constants
import com.app.unsplashgallery.util.runOnMainThread
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UnsplashRepository(private val configHelper: ConfigHelper) {

    fun getImages(
        page: Int = Constants.INITIAL_PAGE,
        perPage: Int = Constants.IMAGE_PER_PAGE,
        orderBy: String = Constants.ORDER_BY,
        onSuccess: (images: List<UnsplashImage>) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        GlobalScope.launch {

            try {
                val images =
                    ApiClient(configHelper.getUnsplashAPIKey()).getPhotos(page, perPage, orderBy)
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