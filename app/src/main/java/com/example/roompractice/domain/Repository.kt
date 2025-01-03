package com.example.roompractice.domain

import com.example.roompractice.com.example.roompractice.domain.entity.BouquetDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowerDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersType

interface Repository {
    suspend fun getFlowers(): List<FlowerDto>

    suspend fun getBouquets(): List<BouquetDto>

    suspend fun getBouquet(name: String): BouquetDto?

    suspend fun reduceFlowersNumber(flower: FlowersType, inequality: Int)
}