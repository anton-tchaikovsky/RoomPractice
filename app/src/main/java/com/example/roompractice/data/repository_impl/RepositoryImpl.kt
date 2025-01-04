package com.example.roompractice.data.repository_impl

import com.example.roompractice.com.example.roompractice.data.mapper.mapFromFlowersDto
import com.example.roompractice.com.example.roompractice.data.mapper.mapToBouquetDto
import com.example.roompractice.com.example.roompractice.data.mapper.mapToFlowersDescriptionDto
import com.example.roompractice.com.example.roompractice.domain.entity.BouquetDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowerDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersDescriptionDto
import com.example.roompractice.data.data_source.LocalDataSource
import com.example.roompractice.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val localDataSource: LocalDataSource) :
    Repository {
    override suspend fun getFlowersDescriptions(): List<FlowersDescriptionDto> =
        withContext(Dispatchers.IO) {
            localDataSource.getFlowers().map {
                mapToFlowersDescriptionDto(it)
            }
        }

    override suspend fun getBouquets(): List<BouquetDto> =
        withContext(Dispatchers.IO) {
            localDataSource.getBouquets().map {
                requireNotNull(mapToBouquetDto(it))
            }
        }

    override suspend fun getBouquet(name: String): BouquetDto? =
        withContext(Dispatchers.IO) { mapToBouquetDto(localDataSource.getBouquet(name)) }

    override suspend fun reduceFlowersNumbers(flowers: List<FlowerDto>) {
        withContext(Dispatchers.IO) {
            localDataSource.reduceFlowersNumbers(mapFromFlowersDto(flowers))
        }
    }
}