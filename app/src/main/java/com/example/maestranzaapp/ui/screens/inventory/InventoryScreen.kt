package com.example.maestranzaapp.ui.screens.inventory

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.maestranzaapp.ui.utils.obtenerWindowSizeClass
import com.example.maestranzaapp.viewmodel.MainViewModel


@Composable
fun InventoryScreen(navController : NavController, viewModel : MainViewModel) {
    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> InventoryScreenCompact(navController, viewModel)
        WindowWidthSizeClass.Medium -> InventoryScreenMedium(navController, viewModel)
        WindowWidthSizeClass.Expanded -> InventoryScreenExpanded(navController, viewModel)
    }
}
