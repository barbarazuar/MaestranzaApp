package com.example.maestranzaapp.ui.screens.home


import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.maestranzaapp.ui.utils.obtenerWindowSizeClass
import com.example.maestranzaapp.viewmodel.MainViewModel


@Composable
fun HomeScreen(navController: NavController, viewModel: MainViewModel) {
    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompact(navController, viewModel)
        WindowWidthSizeClass.Medium -> HomeScreenMedium(navController, viewModel)
        WindowWidthSizeClass.Expanded -> HomeScreenExpanded(navController, viewModel)
    }
}