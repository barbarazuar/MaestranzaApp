package com.example.maestranzaapp.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.maestranzaapp.R
import com.example.maestranzaapp.navigation.Screen
import com.example.maestranzaapp.viewmodel.MainViewModel

@Composable
fun HomeScreenExpanded(
    navController: NavController,
    viewModel: MainViewModel? = null
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(300.dp)
        )

        Column(
            modifier = Modifier.width(500.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Bienvenido a MaestranzaApp",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                text = "Administra productos, usuarios y operaciones de inventario.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Button(
                onClick = { viewModel?.navigateTo(Screen.Inventory) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Comenzar")
            }
        }
    }
}
