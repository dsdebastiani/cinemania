package io.github.dsdebastiani.cinemania.ui.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import io.github.dsdebastiani.cinemania.R
import io.github.dsdebastiani.cinemania.ui.theme.CineManiaTheme
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

class ContentErrorTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun errorMessageIsDisplayedWhenErrorHasMessage() {
        val error = Throwable(
            message = "Some message"
        )
        val tryAgain = mockk<() -> Unit>(relaxed = true)
        every { tryAgain() } returns Unit
        composeTestRule.setContent {
            CineManiaTheme {
                ContentError(error = error, tryAgain = tryAgain)
            }
        }
        composeTestRule
            .onNodeWithTag("ErrorMessage")
            .assertTextContains("Some message")

        composeTestRule.onNodeWithTag("TryAgainButton").performClick()
        verify { tryAgain() }
    }

    @Test
    fun genericErrorMessageIsDisplayedWhenErrorHasMessage() {
        val genericMessage = composeTestRule.activity.getString(R.string.generic_error_message)
        val error = Throwable()
        composeTestRule.setContent {
            CineManiaTheme {
                ContentError(error = error, tryAgain = { })
            }
        }
        composeTestRule
            .onNodeWithTag("ErrorMessage")
            .assertTextContains(genericMessage)
    }

    @Test
    fun tryAgainClickMustInvokeCallBack() {
        val error = Throwable(message = "Some message")
        val tryAgain = mockk<() -> Unit>(relaxed = true)
        every { tryAgain() } returns Unit

        composeTestRule.setContent {
            CineManiaTheme {
                ContentError(error = error, tryAgain = tryAgain)
            }
        }
        composeTestRule
            .onNodeWithTag("TryAgainButton")
            .assertIsDisplayed()
            .performClick()
        verify { tryAgain() }
    }
}
