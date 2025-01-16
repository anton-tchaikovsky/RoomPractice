package com.example.roompractice.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roompractice.com.example.roompractice.data.room.dao.BouquetDao
import com.example.roompractice.data.room.dao.FlowersDao
import com.example.roompractice.data.room.entity.Bouquet
import com.example.roompractice.data.room.entity.Flower

@Database(entities = [Flower::class, Bouquet::class],
    version = 1,
    exportSchema = true)
@TypeConverters(value = [FlowersConverter::class])
abstract class FlowersDatabase: RoomDatabase() {
    abstract fun flowersDao(): FlowersDao

    abstract fun bouquetsDao(): BouquetDao
}