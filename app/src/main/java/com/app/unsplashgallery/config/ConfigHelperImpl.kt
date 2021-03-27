package com.app.unsplashgallery.config

import android.content.Context
import com.app.unsplashgallery.R

class ConfigHelperImpl(private val context: Context) : ConfigHelper {
    override fun getUnsplashAPIKey(): String {
        return context.resources.getString(R.string.UNSPLASH_API_KEY)
    }

    override fun getUnsplashBaseUrl(): String {
        return context.resources.getString(R.string.UNSPLASH_BASE_URL)
    }
}