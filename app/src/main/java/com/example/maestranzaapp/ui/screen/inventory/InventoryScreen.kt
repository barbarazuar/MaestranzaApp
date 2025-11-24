package com.example.maestranzaapp.ui.screen.inventory

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.maestranzaapp.ui.utils.obtenerWindowSizeClass
import com.example.maestranzaapp.viewmodel.MainViewModel


@Composable
fun InventoryScreen(navController : NavController, viewModel : MainViewModel) {
    val searchText by viewModel.searchText.collectAsState()

    OutlinedTextField(
        value = searchText,
        onValueChange = {
            viewModel.saveSearch(it)
        },
        label = { Text("Buscar...") }
    )
    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> InventoryScreenCompact(navController, viewModel)
        WindowWidthSizeClass.Medium -> InventoryScreenMedium(navController, viewModel)
        WindowWidthSizeClass.Expanded -> InventoryScreenExpanded(navController, viewModel)
    }
}