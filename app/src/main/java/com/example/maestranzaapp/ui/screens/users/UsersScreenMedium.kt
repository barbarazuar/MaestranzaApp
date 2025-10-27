package com.example.maestranzaapp.ui.screens.users

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.maestranzaapp.ui.theme.MaestranzaAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersScreenMedium() {
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Gestión de Usuarios") },
                navigationIcon = { IconButton(onClick = { /* Acción futura */ }) { Icon(Icons.Default.Menu, "Menú") } },
                actions = { IconButton(onClick = { /* Acción futura */ }) { Icon(Icons.Default.Notifications, "Notificaciones") } }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Buscar usuario") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                trailingIcon = { Icon(Icons.Default.Search, "Buscar") }
            )
            Spacer(modifier = Modifier.height(16.dp))


            Box(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                LazyColumn(modifier = Modifier.width(700.dp)) {
                    item {
                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Text("Usuario", fontWeight = FontWeight.Bold, modifier = Modifier
                                .width(100.dp)
                                .padding(8.dp))
                            Text("Nombre", fontWeight = FontWeight.Bold, modifier = Modifier
                                .width(180.dp)
                                .padding(8.dp))
                            Text("Email", fontWeight = FontWeight.Bold, modifier = Modifier
                                .width(180.dp)
                                .padding(8.dp))
                            Text("Roles", fontWeight = FontWeight.Bold, modifier = Modifier
                                .width(120.dp)
                                .padding(8.dp))
                            Text("Estado", fontWeight = FontWeight.Bold, modifier = Modifier
                                .width(120.dp)
                                .padding(8.dp))
                        }
                        Divider()
                    }
                    items(dummyUserItems) { user ->
                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Text(user.username, modifier = Modifier
                                .width(100.dp)
                                .padding(8.dp))
                            Text(user.name, modifier = Modifier
                                .width(180.dp)
                                .padding(8.dp))
                            Text(user.email, modifier = Modifier
                                .width(180.dp)
                                .padding(8.dp))
                            Text(user.roles, modifier = Modifier
                                .width(120.dp)
                                .padding(8.dp))
                            Text(user.status, modifier = Modifier
                                .width(120.dp)
                                .padding(8.dp))
                        }
                        Divider()
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "User Medium",
    device = "spec:width=800dp,height=1280dp,dpi=320"
)
@Composable
fun UsersScreenMediumPreview() {
    MaestranzaAppTheme {
        UsersScreenMedium()
    }
}