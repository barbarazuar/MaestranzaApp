package com.example.maestranzaapp.data.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.maestranzaapp.data.model.ProductoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductoDao {

    @Query("SELECT * FROM productos ORDER BY name ASC")
    fun getAll(): Flow<List<ProductoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(producto: ProductoEntity)

    @Delete
    suspend fun delete(producto: ProductoEntity)

    @Query("UPDATE productos SET stock = :newStock WHERE code = :code")
    suspend fun updateStock(code: String, newStock: Int)
}