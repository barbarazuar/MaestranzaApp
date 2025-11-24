package com.example.maestranzaapp.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.maestranzaapp.R
import com.example.maestranzaapp.navigation.Screen
import com.example.maestranzaapp.ui.theme.MaestranzaAppTheme
import com.example.maestranzaapp.viewmodel.MainViewModel

@Composable
fun HomeScreenMedium(
    navController: NavController,
    viewModel: MainViewModel? = null
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .weight(1f)
                .size(260.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Bienvenido a MaestranzaApp",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Sistema de gestión de inventario moderno y fácil de usar.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Button(
                onClick = { viewModel?.navigateTo(Screen.Inventory) },   // ✔ seguro
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text("Comenzar")
            }
        }
    }
}

@Preview(showBackground = true, name = "Medium")
@Composable
fun HomeScreenMediumPreview() {
    MaestranzaAppTheme {
        HomeScreenMedium(
            navController = rememberNavController()

        )
    }
}