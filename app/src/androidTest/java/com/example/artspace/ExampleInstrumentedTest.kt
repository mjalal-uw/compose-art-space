package com.example.artspace

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_clicking_next_to_display_page_2_artwork() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceLayout()
                }
            }
        }
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithContentDescription("Scene 2").assertIsDisplayed()
        composeTestRule.onNodeWithText("Artwork Title 2").assertIsDisplayed()
        composeTestRule.onNodeWithText("Artwork Artist 2 (2022)").assertIsDisplayed()
    }

    @Test
    fun test_clicking_previous_to_display_page_4_artwork() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceLayout()
                }
            }
        }
        composeTestRule.onNodeWithText("Previous").performClick()
        composeTestRule.onNodeWithContentDescription("Scene 4").assertIsDisplayed()
        composeTestRule.onNodeWithText("Artwork Title 4").assertIsDisplayed()
        composeTestRule.onNodeWithText("Artwork Artist 4 (2024)").assertIsDisplayed()
    }

    @Test
    fun test_displaying_initial_artwork() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceLayout()
                }
            }
        }
        composeTestRule.onNodeWithContentDescription("Scene 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Artwork Title 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Artwork Artist 1 (2021)").assertIsDisplayed()
    }

    @Test
    fun test_clicking_next_4_times_display_page_1_artwork() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceLayout()
                }
            }
        }
        repeat(4) {
            composeTestRule.onNodeWithText("Next").performClick()
        }
        composeTestRule.onNodeWithContentDescription("Scene 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Artwork Title 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Artwork Artist 1 (2021)").assertIsDisplayed()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.artspace", appContext.packageName)
    }
}