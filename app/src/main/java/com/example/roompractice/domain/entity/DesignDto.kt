package com.example.roompractice.com.example.roompractice.domain.entity

import androidx.room.ColumnInfo

data class DesignDto(
    @ColumnInfo(name = "is_basket", defaultValue = "0")
    val isBasket: Boolean,
    @ColumnInfo(name = "is_craft_paper", defaultValue = "0")
    val isCraftPaper: Boolean
)