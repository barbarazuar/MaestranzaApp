import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.maestranzaapp.ui.themes.MaestranzaAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Inventario Maestranza") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Gestión de Inventario",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(35.dp))


            Text(
                text = "Gestiona, Optimiza y Controla tu Stock",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )


            Spacer(modifier = Modifier.weight(1f))


            MiBotonComponente()


            Spacer(modifier = Modifier.weight(1f))

        }
    }
}


@Composable
fun MiBotonComponente() {
    val context = LocalContext.current

    Button(
        onClick = {
            Toast.makeText(context, "Iniciando gestión de inventario...", Toast.LENGTH_SHORT).show()
        }
    ) {
        Text("Comenzar ahora")
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MaestranzaAppTheme {
        HomeScreen()
    }
}