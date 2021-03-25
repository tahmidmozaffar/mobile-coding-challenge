package com.app.unsplashgallery

class ApiClient(private val unsplashApiKey: String) {

    suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<UnsplashImage> {
        return RetrofitBuilder.api.getPhotos(
            unsplashApiKey,
            page,
            perPage,
            orderBy
        )
    }
}