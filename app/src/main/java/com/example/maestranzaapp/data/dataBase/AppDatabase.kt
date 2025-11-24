package com.example.maestranzaapp.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.maestranzaapp.data.model.ProductoEntity

@Database(
    entities = [ProductoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productoDao(): ProductoDao
}