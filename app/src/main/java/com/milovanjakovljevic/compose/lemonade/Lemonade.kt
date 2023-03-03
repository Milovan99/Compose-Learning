package com.milovanjakovljevic.compose.lemonade

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.milovanjakovljevic.compose.R


@Composable
fun LemonadeApp(){
LemonadeWithAnimation(modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center))
}

@Composable
fun LemonadeWithAnimation(modifier: Modifier=Modifier){
    var counter=1

    var step by remember {
        mutableStateOf(1)
    }

    var squeeze by remember {
        mutableStateOf(2)
    }
    squeeze=(2..4).random()

    val imageResource=when(step){
        1->R.drawable.lemon_tree
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_drink
        4->R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val textResource=when(step){
        1->R.string.lemonTree
        2->R.string.lemon
        3->R.string.glassOfLemonade
        4->R.string.emptyGlass
        else -> R.string.lemonTree
    }

    Column(
        modifier=modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = textResource))
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier=Modifier.clickable {
                if(step<4 && step!=2){
                      step++
                }else if(step == 2){
                if(counter==squeeze){
                    step++
                }else{
                    counter++
                }
            }else{
                step=1
                    counter=1
                    squeeze=(2..4).random()
                }
            },
            painter = painterResource(id = imageResource),
            contentDescription = step.toString())
    }

}