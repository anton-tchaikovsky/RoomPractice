package com.example.roompractice.com.example.roompractice.data.room.entity

import androidx.room.ColumnInfo

class FlowersNumber(
    @ColumnInfo(defaultValue = "0")
    val rose: Int,
    @ColumnInfo(defaultValue = "0")
    val lily: Int,
    @ColumnInfo(defaultValue = "0")
    val peony: Int,
    @ColumnInfo(defaultValue = "0")
    val tulip: Int,
    @ColumnInfo(defaultValue = "0")
    val orchid: Int,
    @ColumnInfo(defaultValue = "0")
    val aster: Int,
    @ColumnInfo(defaultValue = "0")
    val chrysanthemum: Int,
    @ColumnInfo(defaultValue = "0")
    val carnation: Int,
    @ColumnInfo(defaultValue = "0")
    val iris: Int,
    @ColumnInfo(defaultValue = "0")
    val lilac: Int
)
