package com.example.roompractice.domain

import com.example.roompractice.com.example.roompractice.domain.entity.BouquetDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowerDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersDescriptionDto

interface Repository {
    suspend fun getFlowersDescriptions(): List<FlowersDescriptionDto>

    suspend fun getBouquets(): List<BouquetDto>

    suspend fun getBouquet(name: String): BouquetDto?

    suspend fun reduceFlowersNumbers(flowers: List<FlowerDto>)
}