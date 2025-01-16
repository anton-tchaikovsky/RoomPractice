package com.example.roompractice.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersType
import com.example.roompractice.data.room.entity.Flower

@Dao
interface FlowersDao {
    @Query("SELECT* from flowers")
    fun getFlowers(): List<Flower>

    @Query("UPDATE flowers SET number = (number - :inequality) WHERE flower = :flower")
    fun reduceFlowersNumber(flower: FlowersType, inequality: Int)
}