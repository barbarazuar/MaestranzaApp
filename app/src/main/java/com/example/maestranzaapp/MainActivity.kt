package com.example.maestranzaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.maestranzaapp.navigation.AppNavigation
import com.example.maestranzaapp.ui.theme.MaestranzaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaestranzaAppTheme{

                Scaffold(){ innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        AppNavigation()


                    }
                }

            }
        }
    }
}