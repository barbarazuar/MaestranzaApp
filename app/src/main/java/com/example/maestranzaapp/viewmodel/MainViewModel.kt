package com.example.maestranzaapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import com.example.maestranzaapp.navigation.NavigationEvent
import com.example.maestranzaapp.navigation.Screen
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val _navigationEvents = MutableSharedFlow<NavigationEvent>()
    val navigationEvents: SharedFlow<NavigationEvent> = _navigationEvents.asSharedFlow()

    fun navigateTo(screen: Screen) {
        viewModelScope.launch {
            Log.d("MainViewModel", "Navigating to ${screen.route}")
            _navigationEvents.emit(value = NavigationEvent.NavigateTo(route = screen))
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            Log.d("MainViewModel", "Navigating back")
            _navigationEvents.emit(value = NavigationEvent.PopBackStack)
        }
    }

    fun navigateUp() {
        viewModelScope.launch {
            Log.d("MainViewModel", "Navigating up")
            _navigationEvents.emit(value = NavigationEvent.NavigateUp)
        }
    }

}
