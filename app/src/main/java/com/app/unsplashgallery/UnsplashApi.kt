package com.app.unsplashgallery

import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    @GET("/photos/")
    suspend fun getPhotos(
        @Query("client_id") clientId: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("order_by") orderBy: String
    ): List<UnsplashImage>
}