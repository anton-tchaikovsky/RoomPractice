package com.example.roompractice.com.example.roompractice.domain.interactor

import com.example.roompractice.com.example.roompractice.domain.entity.BouquetDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowerDto

interface Interactor {
    suspend fun getFlowers(): List<FlowerDto>

    suspend fun getBouquets(): List<BouquetDto>

    suspend fun getAvailableBouquets(): List<BouquetDto>

    suspend fun buyBouquet(name: String)
}