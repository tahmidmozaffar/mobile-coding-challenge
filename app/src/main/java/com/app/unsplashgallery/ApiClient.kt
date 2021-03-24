package com.app.unsplashgallery

class ApiClient {

    suspend fun getPhotos(page: Int = 1, perPage: Int = 50, orderBy: String = "latest"): List<UnsplashImage> {
        return RetrofitBuilder.api.getPhotos(
            "fLgwpoJzeXgvOlHzFtNd1OxPa2at8i7sTimn3x9oJ0E",
            page,
            perPage,
            orderBy
        )
    }
}