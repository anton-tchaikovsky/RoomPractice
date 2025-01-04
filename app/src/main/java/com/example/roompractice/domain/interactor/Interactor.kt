package com.example.roompractice.com.example.roompractice.domain.interactor

import com.example.roompractice.com.example.roompractice.domain.entity.BouquetDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersDescriptionDto

interface Interactor {
    suspend fun getFlowersDescriptions(): List<FlowersDescriptionDto>

    suspend fun getBouquets(): List<BouquetDto>

    suspend fun getAvailableBouquets(): List<BouquetDto>

    suspend fun buyBouquet(name: String)
}