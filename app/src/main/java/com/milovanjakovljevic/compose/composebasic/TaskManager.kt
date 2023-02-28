package com.milovanjakovljevic.compose.composebasic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.milovanjakovljevic.compose.R


@Composable
fun TaskManager(){
    val image = painterResource(id =  R.drawable.ic_task_completed)
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Image(painter = image, contentDescription = null , modifier = Modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally).wrapContentHeight(align = Alignment.CenterVertically))
        Text(
            text = "All tasks completed",
            textAlign= TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top=24.dp, bottom = 8.dp)
        )
        Text(
            text = "Nice work!",
            textAlign= TextAlign.Center,
            fontSize = 16.sp,
        )
    }
}

