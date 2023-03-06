package com.milovanjakovljevic.compose

import com.milovanjakovljevic.compose.tip_time.calculateTip
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat


class TipCalculatorTest {
    @Test
    fun calculate_20_percent_tip_no_roundup(){
        val amount=10.0
        val tipPercent=20.00
        val expectedTip= NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}