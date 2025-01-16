package com.example.roompractice.data.room

import androidx.room.TypeConverter
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersType

class FlowersConverter {
    @TypeConverter
    fun fromFlowersType(flower: FlowersType): String {
        return flower.name.lowercase()
    }

    @TypeConverter
    fun toFlowersType(flower: String): FlowersType {
        return FlowersType.valueOf(flower.uppercase())
    }
}