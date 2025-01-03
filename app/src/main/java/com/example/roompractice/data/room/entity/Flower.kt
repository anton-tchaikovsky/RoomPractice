package com.example.roompractice.data.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.roompractice.com.example.roompractice.domain.entity.FlowerDto

@Entity(tableName = "flowers", indices = [Index(value = ["flower"], unique = true)])
class Flower(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @Embedded
    val flower: FlowerDto
)