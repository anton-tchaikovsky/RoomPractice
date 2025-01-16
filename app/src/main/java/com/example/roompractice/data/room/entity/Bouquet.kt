package com.example.roompractice.data.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.roompractice.com.example.roompractice.data.room.entity.FlowersNumber

@Entity(tableName = "bouquets", indices = [Index(value = ["name"], unique = true)])
class Bouquet (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    @Embedded
    val flowersNumber: FlowersNumber
)