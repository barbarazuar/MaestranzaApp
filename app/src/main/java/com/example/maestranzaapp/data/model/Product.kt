package com.example.maestranzaapp.data.model

data class InventoryItem(
    val code: String,
    val name: String,
    val category: String,
    val description: String = "",
    val price: Double = 0.0,
    val stock: Int
)

data class SimpleProducto(
    val id: String,
    val codigo: String,
    val nombre: String,
    val stock: Int
)
