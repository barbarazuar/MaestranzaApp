package com.example.maestranzaapp.ui.screen.users

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.maestranzaapp.ui.utils.obtenerWindowSizeClass
import com.example.maestranzaapp.viewmodel.MainViewModel

@Composable
fun UserScreen(navController : NavController, viewModel : MainViewModel) {
    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> UserScreenCompact(navController, viewModel)
        WindowWidthSizeClass.Medium -> UserScreenMedium(navController, viewModel)
        WindowWidthSizeClass.Expanded -> UserScreenExpanded(navController, viewModel)
    }
}