package com.app.unsplashgallery.data.source.remote

import com.app.unsplashgallery.data.source.remote.network.RetrofitBuilder
import com.app.unsplashgallery.domain.model.UnsplashImage

class ApiClient(private val unsplashApiKey: String, private val baseUrl: String) {

    suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<UnsplashImage> {
        return RetrofitBuilder(baseUrl).api.getPhotos(
            unsplashApiKey,
            page,
            perPage,
            orderBy
        )
    }
}