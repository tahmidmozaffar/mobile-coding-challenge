package com.app.unsplashgallery.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

inline fun runOnMainThread(delayInMillis: Long = 0, crossinline action: () -> Unit) {
    GlobalScope.launch(Dispatchers.Main) {
        delay(delayInMillis)
        action()
    }
}