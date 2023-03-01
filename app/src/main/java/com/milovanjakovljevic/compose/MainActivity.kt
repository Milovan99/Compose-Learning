package com.milovanjakovljevic.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.milovanjakovljevic.compose.composebasic.BusinessCard
import com.milovanjakovljevic.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073042)
                ) {
                  // Article(message = getString(R.string.headline), paragraph =  getString(R.string.paragraph1), paragraph2 =  getString(R.string.paragraph2))
                  // TaskManager()
                  // ComposeQuadrantApp()
                    BusinessCard()
                }
            }
        }
    }
}










