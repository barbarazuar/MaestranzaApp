package com.example.maestranzaapp.ui.model

data class AddProductErrors(
    val codigo: String? = null,
    val nombre: String? = null,
    val categoria: String? = null
)

data class AddProductState(
    val codigo: String = "",
    val nombre: String = "",
    val categoria: String = "",
    val errores: AddProductErrors = AddProductErrors()
)