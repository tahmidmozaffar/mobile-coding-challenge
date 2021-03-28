package com.app.unsplashgallery.domain.usecase.impl

import org.junit.Assert.*
import org.junit.Test

class UpdateScrollPositionUseCaseImplTest {

    @Test
    fun shouldScrollToLastSelectedItem_with_lastSelectedItem_as_null_will_return_false() {
        val updater = UpdateScrollPositionUseCaseImpl()
        assertEquals(updater.shouldScrollToLastSelectedItem(null), false)
    }

    @Test
    fun shouldScrollToLastSelectedItem_with_lastSelectedItem_as_anyNumberLessThanZero_will_return_false() {
        val updater = UpdateScrollPositionUseCaseImpl()
        assertEquals(updater.shouldScrollToLastSelectedItem(-1), false)
    }

    @Test
    fun shouldScrollToLastSelectedItem_with_lastSelectedItem_as_Zero_will_return_true() {
        val updater = UpdateScrollPositionUseCaseImpl()
        assertEquals(updater.shouldScrollToLastSelectedItem(0), true)
    }

    @Test
    fun shouldScrollToLastSelectedItem_with_lastSelectedItem_as_anyNumberGreaterThanOrEqualZero_will_return_true() {
        val updater = UpdateScrollPositionUseCaseImpl()
        assertEquals(updater.shouldScrollToLastSelectedItem(3), true)
    }

}