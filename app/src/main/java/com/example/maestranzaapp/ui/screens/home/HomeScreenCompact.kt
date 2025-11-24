package com.example.maestranzaapp.ui.screens.home

import android.annotation.SuppressLint
import androidx.navigation.NavController
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
import androidx.navigation.compose.rememberNavController
import com.example.maestranzaapp.navigation.Screen
import com.example.maestranzaapp.ui.theme.MaestranzaAppTheme
import com.example.maestranzaapp.viewmodel.MainViewModel
import com.example.maestranzaapp.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenCompact(
    navController: NavController,
    viewModel: MainViewModel
){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de la app",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Bienvenido",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { viewModel.navigateTo(Screen.Inventory) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Comenzar")
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true, name = "Compact", device = "spec:width=411dp,height=891dp,dpi=420")
@Composable
fun HomeScreenCompactPreview(){
    MaestranzaAppTheme {
        HomeScreenCompact(
            navController = rememberNavController(),
            viewModel = MainViewModel()
        )
    }
}