package com.example.maestranzaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
<<<<<<< HEAD
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
=======
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
>>>>>>> 91105c762831adc4eca5fa8ac0a317388cae7205
            }
        }
    }

    NavHost(
        navController = navController,
<<<<<<< HEAD
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
=======
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
>>>>>>> 91105c762831adc4eca5fa8ac0a317388cae7205
            AddProductScreen(
                navController = navController,
                mainViewModel = mainViewModel
            )
        }
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> 91105c762831adc4eca5fa8ac0a317388cae7205
