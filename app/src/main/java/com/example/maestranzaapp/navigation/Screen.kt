package com.example.maestranzaapp.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Inventory : Screen("inventory")
    data object Users : Screen("users")


}