package com.example.maestranzaapp.ui.screens.home

import android.annotation.SuppressLint
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
import com.example.maestranzaapp.ui.theme.MaestranzaAppTheme
import com.example.maestranzaapp.viewmodel.MainViewModel
import com.example.maestranzaapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenExpanded(
    navController: NavController,
    viewModel: MainViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("") })
        }
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(64.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de la app",
                modifier = Modifier
                    .weight(1f)
                    .sizeIn(maxWidth = 250.dp)
            )
            Spacer(modifier = Modifier.width(48.dp))
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bienvenido",
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = { /* Acción futura */ },
                    modifier = Modifier.fillMaxWidth(0.7f)
                ) {
                    Text("Comenzar")
                }
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true, name = "Expanded", device = "spec:width=1280dp,height=800dp,dpi=240" )
@Composable
fun HomeScreenExpandedPreview(){
    MaestranzaAppTheme {
        HomeScreenExpanded(
            navController = rememberNavController(),
            viewModel = MainViewModel()
        )
    }
}