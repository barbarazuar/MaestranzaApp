package com.example.maestranzaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.maestranzaapp.ui.screens.home.WelcomeScreen
import com.example.maestranzaapp.ui.theme.MaestranzaAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaestranzaAppTheme {
                WelcomeScreen()
            }
        }
    }
}