package com.app.unsplashgallery.domain.usecase.impl

import com.app.unsplashgallery.domain.model.UnsplashImage
import com.app.unsplashgallery.domain.repository.UnsplashRepository
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito

class FetchImageUseCaseImplTest {

    private lateinit var unsplashRepository: UnsplashRepository
    private val onSuccess: (images: List<UnsplashImage>) -> Unit = {
        println(it)
    }
    private val onFailure: (message: String) -> Unit = {
        println(it)
    }

    @Before
    fun beforeTest() {
        unsplashRepository = Mockito.mock(UnsplashRepository::class.java)
    }

    @Test
    fun whenFetchIsCalled_getImages_of_repository_willbecalled_once() {
        val fetchImageUseCaseImpl = FetchImageUseCaseImpl(unsplashRepository)
        fetchImageUseCaseImpl.fetch(2, 20, "newest", onSuccess, onFailure)
        Mockito.verify(unsplashRepository, Mockito.times(1))
            .getImages(
                2, 20, "newest", onSuccess, onFailure
            )
    }

    @Test
    fun whenFetchIsCalled_getImages_of_repository_willbecalled_withSameParameters() {
        val fetchImageUseCaseImpl = FetchImageUseCaseImpl(unsplashRepository)
        fetchImageUseCaseImpl.fetch(2, 20, "newest", onSuccess, onFailure)
        Mockito.verify(unsplashRepository).getImages(2, 20, "newest", onSuccess, onFailure)

    }

    @After
    fun clear() {
        Mockito.reset(unsplashRepository)
    }
}