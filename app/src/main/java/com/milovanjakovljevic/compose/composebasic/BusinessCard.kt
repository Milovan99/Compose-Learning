package com.milovanjakovljevic.compose.composebasic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.milovanjakovljevic.compose.R


@Composable 
fun BusinessCard(){
    MainInfo()
    DetailsInfo()
}

@Composable
fun MainInfo(){
    val image= painterResource(id = R.drawable.and)
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.padding(bottom = 30.dp)) {

        Image(painter = image, contentDescription = "Android logo", modifier = Modifier.height(height =
        60.dp).width(width = 80.dp))
        Text(
            text = "Milovan Jakovljevic",
            color = Color(0xFFF9FAFB),
            fontSize = 30.sp
        )
        Text(text = "Junior Android developer",
        color = Color(0xFF3ddc84))
    }
}


@Composable
fun DetailsInfo(){
    Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.padding(bottom = 25.dp))
    {
        Divider(startIndent = 1.dp, thickness = 2.dp, color = Color(0xFF526E7B))
        Row(modifier = Modifier.padding(all = 10.dp)){
            Spacer(modifier = Modifier.width(30.dp))
            Icon(Icons.Rounded.Phone, "", tint = Color(0xFF3ddc84))
            Spacer(modifier = Modifier.width(30.dp))
            Text(  color = Color(0xFFF9FAFB),
                text = "+381 65 452 0007")
        }
        Divider(startIndent = 1.dp, thickness = 2.dp, color = Color(0xFF526E7B))
        Row(modifier = Modifier.padding(all = 10.dp)){
            Spacer(modifier = Modifier.width(30.dp))
            Icon(Icons.Rounded.Share, "",tint = Color(0xFF3ddc84))
            Spacer(modifier = Modifier.width(30.dp))
            Text(  color = Color(0xFFF9FAFB),
                text = "@milovan-jakovljevic")
        }
        Divider(startIndent =1.dp, thickness = 2.dp, color = Color(0xFF526E7B))
        Row(modifier = Modifier.padding(all = 10.dp)){
            Spacer(modifier = Modifier.width(30.dp))
            Icon(Icons.Rounded.Email, "",tint = Color(0xFF3ddc84))
            Spacer(modifier = Modifier.width(30.dp))
            Text(  color = Color(0xFFF9FAFB),
                text = "milovanjakovljevic78@gmai.com")
        }
    }
}