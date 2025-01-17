package com.app.unsplashgallery.domain.repository

import com.app.unsplashgallery.domain.model.UnsplashImage

interface UnsplashRepository {
    fun getImages(
        page: Int,
        perPage: Int,
        orderBy: String,
        onSuccess: (images: List<UnsplashImage>) -> Unit,
        onFailure: (message: String) -> Unit
    )
}