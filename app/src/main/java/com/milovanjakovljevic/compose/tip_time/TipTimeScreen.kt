package com.milovanjakovljevic.compose.tip_time

import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.milovanjakovljevic.compose.R
import java.text.NumberFormat


@Composable
fun EditNumberField(
    @StringRes label:Int,
    value:String, onValueChange:(String)->Unit,
    modifier: Modifier=Modifier,
    keyboardOptions: KeyboardOptions,
    keyboardActions:KeyboardActions){

    TextField(
        value = value,
        onValueChange =onValueChange,
        label = { Text(text = stringResource(id = label),modifier=Modifier.fillMaxWidth())},
        keyboardOptions = keyboardOptions,
        keyboardActions=keyboardActions,
        singleLine = true)
}

@Composable
fun RoundTheTipRow(
    roundUp:Boolean,
    onRoundUpChange:(Boolean)->Unit,
    modifier: Modifier=Modifier
){
    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically){
        Text(text = stringResource(id = R.string.round_up_tip))
        Switch(checked = roundUp, onCheckedChange = onRoundUpChange, modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.End),
        colors = SwitchDefaults.colors(uncheckedThumbColor = Color.DarkGray))
    }
}
@VisibleForTesting
 fun calculateTip(amount:Double,tipPercent:Double=15.0,roundUp: Boolean):String{
var tip = tipPercent/100 * amount
    if(roundUp){
        tip=kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}