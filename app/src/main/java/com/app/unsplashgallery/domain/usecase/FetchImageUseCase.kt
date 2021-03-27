package com.app.unsplashgallery.domain.usecase

import com.app.unsplashgallery.domain.model.UnsplashImage

interface FetchImageUseCase {

    fun fetch(
        page: Int,
        perPage: Int,
        orderBy: String,
        onSuccess: (images: List<UnsplashImage>) -> Unit,
        onFailure: (message: String) -> Unit
    )
}