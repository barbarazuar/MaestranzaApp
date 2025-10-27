package com.example.maestranzaapp.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Inventory : Screen("inventario")
    data object Users : Screen("usuarios")

    data object AddProduct : Screen("agregarProduct")


}