package com.app.unsplashgallery.repository

import com.app.unsplashgallery.*
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