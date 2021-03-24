package com.app.unsplashgallery

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnsplashImage(
    val id: String,
    val created_at: String,
    val updated_at: String,
    val width: Int,
    val height: Int,
    val likes: Int,
    val description: String?,
    val urls: Urls
) : Parcelable
