package com.example.maestranzaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maestranzaapp.data.dataBase.ProductoDao
import com.example.maestranzaapp.data.model.ProductoEntity
import com.example.maestranzaapp.data.preferences.UserPreferences
import com.example.maestranzaapp.navigation.NavigationEvent
import com.example.maestranzaapp.navigation.Screen
import com.example.maestranzaapp.ui.screen.inventory.InventoryItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val dao: ProductoDao,
    private val prefs: UserPreferences
) : ViewModel() {
    val searchText = prefs.searchTextFlow.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        ""
    )

    fun saveSearch(text: String) {
        viewModelScope.launch {
            prefs.saveSearchText(text)
        }
    }
    private val _navigationEvents = MutableSharedFlow<NavigationEvent>()
    val navigationEvents = _navigationEvents.asSharedFlow()

    fun navigateTo(screen: Screen) {
        viewModelScope.launch {
            _navigationEvents.emit(NavigationEvent.NavigateTo(route = screen))
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            _navigationEvents.emit(NavigationEvent.PopBackStack)
        }
    }

    fun navigateUp() {
        viewModelScope.launch {
            _navigationEvents.emit(NavigationEvent.NavigateUp)
        }
    }
    private val _cargando = MutableStateFlow(true)
    val cargando = _cargando.asStateFlow()

    init {

        viewModelScope.launch {
            delay(1000)
            _cargando.value = false
        }
    }
    val inventoryItems = dao.getAll()
        .map { listaBD ->
            listaBD.map { entity ->
                InventoryItem(
                    code = entity.code,
                    name = entity.name,
                    category = entity.category,
                    stock = entity.stock
                )
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )


    fun addProduct(code: String, name: String, category: String, stock: Int = 0) {
        viewModelScope.launch {
            dao.insert(
                ProductoEntity(
                    code = code.trim().uppercase(),
                    name = name.trim(),
                    category = category.trim(),
                    stock = stock
                )
            )
        }
    }

    fun deleteProduct(item: InventoryItem) {
        viewModelScope.launch {
            dao.delete(
                ProductoEntity(
                    code = item.code,
                    name = item.name,
                    category = item.category,
                    stock = item.stock
                )
            )
        }
    }

    fun updateStock(code: String, newStock: Int) {
        viewModelScope.launch {
            dao.updateStock(code, newStock)
        }
    }
}