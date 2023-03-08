package com.milovanjakovljevic.compose.art_space

import android.util.Log.d
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.milovanjakovljevic.compose.R

@Preview
@Composable
fun ArtSpaceApp(){
    Column(
        modifier = Modifier.padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        ImageDisplayWithButtons()
    }
}

@Composable
fun ImageDisplayWithButtons(
    modifier: Modifier = Modifier
){
    var counter by remember {
        mutableStateOf(1)
    }

    val imageResource = when(counter){
        1-> R.drawable.android_learning1
        2->R.drawable.android_learning2
        3->R.drawable.android_learning3
        4->R.drawable.android_learning4
        else->R.drawable.android_learning1
    }

    val textTitleResource = when(counter){
        1-> R.string.artwork_title1
        2->R.string.artwork_title2
        3->R.string.artwork_title3
        4->R.string.artwork_title4
        else->R.string.artwork_title1
    }
    val textDescriptionResource = when(counter){
        1-> R.string.artwork_description1
        2->R.string.artwork_description2
        3->R.string.artwork_description3
        4->R.string.artwork_description4
        else->R.string.artwork_description1
    }

   Box(  modifier=Modifier.shadow(4.dp))
   { Image(modifier = Modifier.padding(30.dp),painter = painterResource(id =imageResource ), contentDescription = counter.toString(),)}
    Spacer(modifier = Modifier.height(32.dp))
    Box(modifier = Modifier.shadow(2.dp).fillMaxWidth()){Column(modifier = Modifier.padding(24.dp)) {
        Text(
            text = stringResource(id = textTitleResource),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp)

        Text(text = stringResource(id = textDescriptionResource),
            fontSize = 16.sp)
    }}
    Spacer(modifier = Modifier.height(32.dp))
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Button(modifier = Modifier.width(140.dp),
            onClick = {
            if(counter>1){
                counter--
            }else{
                counter=4
            }
        }) {
            Text(text = "Previous")
        }

        Button(modifier = Modifier.width(140.dp)
            ,onClick = {
            if(counter<4){
                counter++
            }else{
                counter=1
            }
        }) {
            Text(text = "Next")
        }

    }
}



