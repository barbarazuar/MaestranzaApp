package com.example.maestranzaapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.maestranzaapp.R
import com.example.maestranzaapp.ui.themes.MaestranzaAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreenMedium() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Medium") })
        }
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de la app",
                modifier = Modifier.weight(1f).sizeIn(maxWidth = 200.dp)
            )
            Spacer(modifier = Modifier.width(32.dp))
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bienvenido",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = { /* Acción futura */ },
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Text("Comenzar")
                }
            }
        }
    }
}
@Preview(showBackground = true, name = "Medium", device = "spec:width=800dp,height=1280dp,dpi=320" )
@Composable
fun WelcomeScreenMediumPreview(){
    MaestranzaAppTheme {
        WelcomeScreenMedium()
    }
}