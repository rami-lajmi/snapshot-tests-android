package com.example.exploscreenshottesting

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.exploscreenshottesting.ui.components.DeviceCard
import com.example.exploscreenshottesting.ui.components.DeviceDataItem
import com.example.exploscreenshottesting.ui.components.SimpleIconButton
import com.example.exploscreenshottesting.ui.components.StateChip
import com.example.exploscreenshottesting.ui.components.UserInput
import com.karumi.shot.ScreenshotTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UIComponentsScreenShotTest: ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testSelectedStateChip() {
        composeRule.setContent {
            val textChipRememberOneState = remember {
                mutableStateOf(true)
            }
            StateChip(
                isSelected = textChipRememberOneState.value,
                text = "Android",
                selectedColor = Color.Blue.copy(0.25f),
                onChecked = {
                    textChipRememberOneState.value = it
                }
            )
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun testUnSelectedStateChip() {
        composeRule.setContent {
            val textChipRememberOneState = remember {
                mutableStateOf(false)
            }

            StateChip(
                isSelected = textChipRememberOneState.value,
                text = "Android",
                selectedColor = Color.Blue.copy(0.25f),
                onChecked = {
                    textChipRememberOneState.value = it
                }
            )
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun testUserInput() {
        composeRule.setContent {
            var textValue: String by remember { mutableStateOf("") }
            val focusRequester = remember { FocusRequester() }

            UserInput(
                label = "",
                placeholder = "Je cherche un appareil",
                icon = Icons.Default.Search,
                focusRequester = focusRequester,
                textState = textValue,
                onValueChanged = { newValue ->
                    textValue = newValue },
                onClick = {}
            )
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun testSimpleIconButton() {
        composeRule.setContent {
            SimpleIconButton(
                icon = Icons.Default.Add
            )
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun testProductCard() {
        composeRule.setContent {
            ProductCard(Product("Product 1", 19.5))
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun testiOSDeviceCard() {
        composeRule.setContent {
            DeviceCard(DeviceDataItem("Iphone 15 Pro", "11", "2023", R.drawable.iphone_15_pro))
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun testAndroidDeviceCard() {
        composeRule.setContent {
            DeviceCard(DeviceDataItem("Samsung Galaxy", "11", "2021", R.drawable.samsung_galaxy))
        }
        compareScreenshot(composeRule)
    }
}