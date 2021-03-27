package com.app.unsplashgallery.domain.repository

import com.app.unsplashgallery.config.ConfigHelper
import com.app.unsplashgallery.data.source.remote.ApiClient
import com.app.unsplashgallery.domain.model.UnsplashImage
import com.app.unsplashgallery.util.runOnMainThread
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UnsplashRepositoryImpl(private val configHelper: ConfigHelper) : UnsplashRepository {

    override fun getImages(
        page: Int,
        perPage: Int,
        orderBy: String,
        onSuccess: (images: List<UnsplashImage>) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        GlobalScope.launch {

            try {
                val images =
                    ApiClient(
                        configHelper.getUnsplashAPIKey(),
                        configHelper.getUnsplashBaseUrl()
                    ).getPhotos(page, perPage, orderBy)
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