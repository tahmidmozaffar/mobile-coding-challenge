package com.app.unsplashgallery

import android.content.Context

class ConfigHelperImpl(private val context: Context) : ConfigHelper {
    override fun getUnsplashAPIKey(): String {
        return context.resources.getString(R.string.UNSPLASH_API_KEY)
    }
}