package com.milovanjakovljevic.compose

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.milovanjakovljevic.compose.tip_time.TipTimeScreen
import com.milovanjakovljevic.compose.ui.theme.ComposeTheme
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
@Ignore
class TipUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            ComposeTheme {
                    TipTimeScreen()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found."
        )
    }
}
