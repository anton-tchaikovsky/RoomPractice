package com.example.roompractice.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersType
import com.example.roompractice.data.room.entity.Flower

@Dao
interface FlowersDao {
    @Query("SELECT* from flowers")
    fun getFlowers(): List<Flower>

    @Query("UPDATE flowers SET number = (number - :inequality) WHERE flower = :flower")
    fun reduceFlowersNumber(flower: FlowersType, inequality: Int)

    @Query("UPDATE flowers SET country = :country WHERE flower = :flower")
    fun insertCountryForFlower(flower: FlowersType, country: String)

    @Transaction
    fun insertCountriesForFlowers(countries: Map<FlowersType, String>) {
        countries.forEach {
            insertCountryForFlower(it.key, it.value)
        }
    }

    @Transaction
    fun reduceFlowersNumbers(flowers: Map<FlowersType, Int>) {
        flowers.forEach {
            reduceFlowersNumber(it.key, it.value)
        }
    }
}