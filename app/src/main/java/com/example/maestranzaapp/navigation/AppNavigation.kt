package com.example.maestranzaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maestranzaapp.ui.screens.ResumenScreen
import com.example.maestranzaapp.viewmodel.UsuarioViewModel
import com.example.maestranzaapp.ui.screens.RegistroUsuarioScreen
import com.example.maestranzaapp.ui.screens.agregarProducto.AddProductScreen
import com.example.maestranzaapp.ui.screens.home.HomeScreen
import com.example.maestranzaapp.ui.screens.inventory.InventoryScreen
import com.example.maestranzaapp.ui.screens.users.UserScreen
import com.example.maestranzaapp.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val usuarioViewModel: UsuarioViewModel = viewModel()
    val mainViewModel : MainViewModel = viewModel()

    LaunchedEffect(key1 = Unit) {
        mainViewModel.navigationEvents.collectLatest { event ->
            when (event) {
                is NavigationEvent.NavigateTo -> {
                    navController.navigate(route = event.route.route)
                }

                is NavigationEvent.PopBackStack -> {
                    navController.popBackStack()
                }

                is NavigationEvent.NavigateUp -> {
                    navController.navigateUp()
                }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,

    ) {

        composable(route = "registro") {
            RegistroUsuarioScreen(navController, usuarioViewModel)
        }
        composable(route = "resumen") {
            ResumenScreen(usuarioViewModel)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = Screen.Inventory.route){
            InventoryScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = Screen.Users.route){
            UserScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = Screen.AddProduct.route){
            AddProductScreen(
                navController = navController,
                mainViewModel = mainViewModel
            )
        }
    }

}