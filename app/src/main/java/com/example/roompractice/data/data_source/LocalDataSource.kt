package com.example.roompractice.data.data_source

import com.example.roompractice.com.example.roompractice.domain.entity.FlowersType
import com.example.roompractice.data.room.entity.Bouquet
import com.example.roompractice.data.room.entity.Flower

interface LocalDataSource {
    suspend fun getFlowers(): List<Flower>

    suspend fun getBouquets(): List<Bouquet>

    suspend fun getBouquet(name: String): Bouquet?

    suspend fun reduceFlowersNumbers(flowers: Map<FlowersType, Int>)
}