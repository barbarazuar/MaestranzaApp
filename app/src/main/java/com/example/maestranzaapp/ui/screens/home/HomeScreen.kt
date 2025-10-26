package com.example.maestranzaapp.ui.screens.home

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.example.maestranzaapp.ui.utils.obtenerWindowSizeClass


@Composable
fun WelcomeScreen() {
    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> WelcomeScreenCompact()
        WindowWidthSizeClass.Medium -> WelcomeScreenMedium()
        WindowWidthSizeClass.Expanded -> WelcomeScreenExpanded()
    }
}