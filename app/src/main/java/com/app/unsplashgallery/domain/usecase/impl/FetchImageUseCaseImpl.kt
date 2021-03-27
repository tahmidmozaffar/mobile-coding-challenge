package com.app.unsplashgallery.domain.usecase.impl

import com.app.unsplashgallery.domain.model.UnsplashImage
import com.app.unsplashgallery.domain.repository.UnsplashRepository
import com.app.unsplashgallery.domain.usecase.FetchImageUseCase

class FetchImageUseCaseImpl(private val repository: UnsplashRepository) : FetchImageUseCase {

    override fun fetch(
        page: Int,
        perPage: Int,
        orderBy: String,
        onSuccess: (images: List<UnsplashImage>) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        repository.getImages(page, perPage, orderBy, onSuccess, onFailure)
    }
}