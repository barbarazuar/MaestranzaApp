package com.example.maestranzaapp.ui.screen.agregarProducto


import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.maestranzaapp.ui.theme.MaestranzaAppTheme
import com.example.maestranzaapp.viewmodel.AddProductViewModel
import com.example.maestranzaapp.viewmodel.MainViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(
    navController: NavController,
    mainViewModel: MainViewModel,
    viewModel: AddProductViewModel = viewModel()
) {

    val estado by viewModel.estado.collectAsState()
    val inventoryList by mainViewModel.inventoryItems.collectAsState()
    val context = LocalContext.current


    var intentoGuardar by rememberSaveable { mutableStateOf(false) }
    var mostrarExito by rememberSaveable { mutableStateOf(false) }


    val formValido by remember(estado) {
        derivedStateOf {
            estado.codigo.isNotBlank() &&
                    estado.nombre.isNotBlank() &&
                    estado.categoria.isNotBlank() &&
                    estado.errores.codigo == null &&
                    estado.errores.nombre == null &&
                    estado.errores.categoria == null
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agregar Producto") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver atrás"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp)
        ) {

            OutlinedTextField(
                value = estado.codigo,
                onValueChange = {
                    viewModel.onCodigoChange(it)
                    if (intentoGuardar) viewModel.validarFormulario(inventoryList)
                },
                label = { Text("Código del Producto") },
                placeholder = { Text("Ej: HCOR-001") },
                isError = estado.errores.codigo != null,
                supportingText = {
                    estado.errores.codigo?.let {
                        Text(text = it, color = MaterialTheme.colorScheme.error)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = estado.nombre,
                onValueChange = {
                    viewModel.onNombreChange(it)
                    if (intentoGuardar) viewModel.validarFormulario(inventoryList)
                },
                label = { Text("Nombre del Producto") },
                isError = estado.errores.nombre != null,
                supportingText = {
                    estado.errores.nombre?.let {
                        Text(text = it, color = MaterialTheme.colorScheme.error)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = estado.categoria,
                onValueChange = {
                    viewModel.onCategoriaChange(it)
                    if (intentoGuardar) viewModel.validarFormulario(inventoryList)
                },
                label = { Text("Categoría") },
                isError = estado.errores.categoria != null,
                supportingText = {
                    estado.errores.categoria?.let {
                        Text(text = it, color = MaterialTheme.colorScheme.error)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    intentoGuardar = true

                    val ok = viewModel.validarFormulario(inventoryList)
                    if (ok) {
                        mainViewModel.addProduct(
                            code = estado.codigo,
                            name = estado.nombre,
                            category = estado.categoria
                        )


                        mostrarExito = true
                    }
                },
                enabled = formValido,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Guardar Producto")
            }

            AnimatedVisibility(visible = mostrarExito) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Text(
                        text = "Producto guardado con éxito",
                        modifier = Modifier.padding(12.dp),
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }


            LaunchedEffect(mostrarExito) {
                if (mostrarExito) {
                    delay(1200)
                    mostrarExito = false
                    navController.popBackStack()
                }
            }
        }
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun AddProductScreenPreview() {
    MaestranzaAppTheme {
        AddProductScreen(navController = rememberNavController(),
            mainViewModel = MainViewModel())
    }
}