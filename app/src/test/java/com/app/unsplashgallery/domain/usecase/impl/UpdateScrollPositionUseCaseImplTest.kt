package com.app.unsplashgallery.domain.usecase.impl

import org.junit.Assert.*
import org.junit.Test

class UpdateScrollPositionUseCaseImplTest {

    @Test
    fun shouldScrollToLastSelectedItem_with_lastSelectedItem_as_null_will_return_false() {
        val updater = UpdateScrollPositionUseCaseImpl(null)
        assertEquals(updater.shouldScrollToLastSelectedItem(), false)
    }

    @Test
    fun shouldScrollToLastSelectedItem_with_lastSelectedItem_as_anyNumberLessThanZero_will_return_false() {
        val updater = UpdateScrollPositionUseCaseImpl(-1)
        assertEquals(updater.shouldScrollToLastSelectedItem(), false)
    }

    @Test
    fun shouldScrollToLastSelectedItem_with_lastSelectedItem_as_Zero_will_return_true() {
        val updater = UpdateScrollPositionUseCaseImpl(0)
        assertEquals(updater.shouldScrollToLastSelectedItem(), true)
    }

    @Test
    fun shouldScrollToLastSelectedItem_with_lastSelectedItem_as_anyNumberGreaterThanOrEqualZero_will_return_true() {
        val updater = UpdateScrollPositionUseCaseImpl(3)
        assertEquals(updater.shouldScrollToLastSelectedItem(), true)
    }

}