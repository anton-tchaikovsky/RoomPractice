package com.example.roompractice.com.example.roompractice.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class FlowersDescriptionDto(
    @Embedded
    val flower: FlowerDto,
    @ColumnInfo(defaultValue = "indefinite")
    val country: String
)
