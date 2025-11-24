package com.example.maestranzaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
<<<<<<< HEAD
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.maestranzaapp.data.dataBase.AppDatabase
import com.example.maestranzaapp.data.dataBase.ProductoDao
import com.example.maestranzaapp.data.preferences.UserPreferences
import com.example.maestranzaapp.navigation.AppNavigation
import com.example.maestranzaapp.ui.theme.MaestranzaAppTheme
import com.example.maestranzaapp.viewmodel.MainViewModel
=======
import com.example.maestranzaapp.navigation.AppNavigation
import com.example.maestranzaapp.ui.theme.MaestranzaAppTheme
>>>>>>> 91105c762831adc4eca5fa8ac0a317388cae7205

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
<<<<<<< HEAD

        setContent {
            MaestranzaAppTheme {

                val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java,
                    "maestranza-db"
                ).build()

                val productoDao = db.productoDao()

                val prefs = UserPreferences(applicationContext)

                val mainViewModel: MainViewModel = viewModel(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return MainViewModel(ProductoDao) as T
                        }
                    }
                )

                Scaffold { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation(MainViewModel)
                    }
                }
            }
        }
    }
}
=======
        setContent {
            MaestranzaAppTheme{

                Scaffold(){ innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        AppNavigation()


                    }
                }

            }
        }
    }
}
>>>>>>> 91105c762831adc4eca5fa8ac0a317388cae7205
