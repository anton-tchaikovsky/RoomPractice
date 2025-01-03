package com.example.roompractice.com.example.roompractice.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.roompractice.data.room.entity.Bouquet

@Dao
interface BouquetDao {
    @Query("SELECT*from bouquets")
    fun getBouquets(): List<Bouquet>

    @Query("SELECT*from bouquets WHERE name =:name")
    fun getBouquetsByName(name: String): Bouquet?
}