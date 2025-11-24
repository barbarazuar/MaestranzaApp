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
fun HomeScreenCompact(
    navController: NavController,
    viewModel: MainViewModel? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(160.dp)
        )

        Text(
            text = "Bienvenido a MaestranzaApp",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
        )

        Text(
            text = "Gestiona inventario, usuarios y más.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = { viewModel?.navigateTo(Screen.Inventory) },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Comenzar")
        }
    }
}

@Preview(showBackground = true, name = "Compact")
@Composable
fun HomeScreenCompactPreview() {
    MaestranzaAppTheme {
        HomeScreenCompact(
            navController = rememberNavController()

        )
    }
}