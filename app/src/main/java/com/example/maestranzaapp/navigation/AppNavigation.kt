package com.example.maestranzaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maestranzaapp.ui.screen.RegistroUsuarioScreen
import com.example.maestranzaapp.ui.screen.ResumenScreen
import com.example.maestranzaapp.ui.screen.agregarProducto.AddProductScreen
import com.example.maestranzaapp.ui.screen.home.HomeScreen
import com.example.maestranzaapp.ui.screen.inventory.InventoryScreen
import com.example.maestranzaapp.ui.screen.users.UserScreen
import com.example.maestranzaapp.viewmodel.UsuarioViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppNavigation(mainViewModel: Unit) {

    val navController = rememberNavController()
    val usuarioViewModel: UsuarioViewModel = viewModel()

    LaunchedEffect(Unit) {
        mainViewModel.navigationEvents.collectLatest { event ->
            when (event) {
                is NavigationEvent.NavigateTo -> {
                    navController.navigate(event.route.route)
                }
                is NavigationEvent.PopBackStack -> navController.popBackStack()
                is NavigationEvent.NavigateUp -> navController.navigateUp()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable("registro") {
            RegistroUsuarioScreen(navController, usuarioViewModel)
        }

        composable("resumen") {
            ResumenScreen(usuarioViewModel)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController, mainViewModel)
        }

        composable(Screen.Inventory.route) {
            InventoryScreen(navController, mainViewModel)
        }

        composable(Screen.Users.route) {
            UserScreen(navController, mainViewModel)
        }

        composable(Screen.AddProduct.route) {
            AddProductScreen(
                navController = navController,
                mainViewModel = mainViewModel
            )
        }
    }
}
