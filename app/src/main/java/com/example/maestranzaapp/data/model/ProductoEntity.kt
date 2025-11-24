package com.example.maestranzaapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class ProductoEntity(
    @PrimaryKey val code: String,
    val name: String,
    val category: String,
    val stock: Int
)