package com.example.maestranzaapp.ui.screens.users

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.maestranzaapp.ui.utils.obtenerWindowSizeClass
import com.example.maestranzaapp.viewmodel.MainViewModel

@Composable
fun UsersScreen(navController: NavController, viewModel: MainViewModel) {
    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> UsersScreenCompact()
        WindowWidthSizeClass.Medium -> UsersScreenMedium()
        WindowWidthSizeClass.Expanded -> UsersScreenExpanded()
    }
}