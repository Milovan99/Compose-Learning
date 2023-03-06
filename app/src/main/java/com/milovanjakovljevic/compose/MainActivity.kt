package com.milovanjakovljevic.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.milovanjakovljevic.compose.composebasic.BusinessCard
import com.milovanjakovljevic.compose.dice_roller.DiceRollerApp

import com.milovanjakovljevic.compose.dice_roller.DiceWithAnimationAndButton
import com.milovanjakovljevic.compose.lemonade.LemonadeApp
import com.milovanjakovljevic.compose.tip_time.EditNumberField
import com.milovanjakovljevic.compose.tip_time.RoundTheTipRow
import com.milovanjakovljevic.compose.tip_time.calculateTip
import com.milovanjakovljevic.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
               /* Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073042)
                ) {*/
                    //compose basic elements
                  // Article(message = getString(R.string.headline), paragraph =  getString(R.string.paragraph1), paragraph2 =  getString(R.string.paragraph2))
                  // TaskManager()
                  // ComposeQuadrantApp()
                  //  BusinessCard()

                //DiceRollerApp()
                //LemonadeApp()
                TipTimeScreen()
                }
            }
        }
    }
@Composable
fun TipTimeScreen(){
    var amountInput by remember{ mutableStateOf("") }
    val amount=amountInput.toDoubleOrNull() ?: 0.0
    var tipInput by remember {  mutableStateOf("")    }
    val tipPercent=tipInput.toDoubleOrNull() ?: 0.0
    var roundUp by remember { mutableStateOf(false)  }
    val tip= calculateTip(amount,tipPercent,roundUp)

    val focusManager= LocalFocusManager.current
    Column(modifier = Modifier.padding(32.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(text = stringResource(id = R.string.calculate_tip), fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))
        EditNumberField(
            label = R.string.bill_amount,
            value=amountInput, onValueChange = {amountInput=it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions (onNext = {focusManager.moveFocus(focusDirection = FocusDirection.Down)})
        )
        EditNumberField(
            label = R.string.how_was_the_service,
            value = tipInput, onValueChange ={tipInput=it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions (onDone  = {focusManager.clearFocus()})
        )
        RoundTheTipRow(roundUp = roundUp, onRoundUpChange = {roundUp=it})
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.tip_amount,tip), modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 20.sp, fontWeight = FontWeight.Bold)

    }
}












