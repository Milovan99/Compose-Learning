package com.milovanjakovljevic.compose

import android.os.Bundle
import android.provider.Settings.Secure.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.milovanjakovljevic.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  //  Article(message = getString(R.string.headline), paragraph =  getString(R.string.paragraph1), paragraph2 =  getString(R.string.paragraph2))
                    TaskManager()
                }
            }
        }
    }
}

@Composable
fun TaskManager(){
    val image = painterResource(id =  R.drawable.ic_task_completed)
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Image(painter = image, contentDescription = null , modifier = Modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally).wrapContentHeight(align = Alignment.CenterVertically))
        Text(
            text = "All tasks completed",
            textAlign=TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top=24.dp, bottom = 8.dp)
        )
        Text(
            text = "Nice work!",
            textAlign=TextAlign.Center,
            fontSize = 16.sp,
        )
    }
}












@Composable
fun Article(message: String, paragraph:String, paragraph2: String){
    val image = painterResource(id=R.drawable.bg_compose_background)
   Column{
       Image(painter = image, contentDescription =null,modifier=Modifier.fillMaxWidth() )
       HeadlineText(text=message)
       ParagraphText(paragraph = paragraph)
       ParagraphText2(paragraph = paragraph2)
   }
}

@Composable
fun HeadlineText(text: String){

    Column() {
        Text(
            text=text,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(all = 16.dp))
            }
}
@Composable
fun ParagraphText(paragraph: String){
    Column() {
        Text(
            text=paragraph,
            fontSize =16.sp,
            textAlign=TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 16.dp, end = 16.dp))
    }
}
@Composable
fun ParagraphText2(paragraph: String){
    Column() {
        Text(
            text=paragraph,
            fontSize =16.sp,
            textAlign=TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(all = 16.dp))
    }
}

