package com.example.maestranzaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.maestranzaapp.navigation.Screen
import com.example.maestranzaapp.viewmodel.MainViewModel


@Composable
fun HomeScreen(navController: NavController, viewModel: MainViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "¡Bienvenido a Maestranza!")

        Button(
            onClick = {
                Log.d("HomeScreen", "Botón 'Ir a Inventario' clickeado.")
                viewModel.navigateTo(Screen.Inventory)
            }
        ) {
            Text("Ir a Inventario")
        }

        Button(
            onClick = {
                Log.d("HomeScreen", "Botón 'Ir a Usuarios' clickeado.")
                viewModel.navigateTo(Screen.Users)
            }
        ) {
            Text("Ver Usuarios")
        }

        Button(
            onClick = {
                Log.d("HomeScreen", "Botón 'Modificar Inventario' clickeado.")
                viewModel.navigateBack()
            }
        ) {
            Text("Modificar Inventario")
        }
    }
}