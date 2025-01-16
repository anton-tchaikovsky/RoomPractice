package com.example.roompractice.data.repository_impl

import com.example.roompractice.com.example.roompractice.data.mapper.mapToBouquetDto
import com.example.roompractice.com.example.roompractice.data.mapper.mapToFlowerDto
import com.example.roompractice.com.example.roompractice.domain.entity.BouquetDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowerDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersType
import com.example.roompractice.data.data_source.LocalDataSource
import com.example.roompractice.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val localDataSource: LocalDataSource) :
    Repository {
    override suspend fun getFlowers(): List<FlowerDto> =
        withContext(Dispatchers.IO) {
            localDataSource.getFlowers().map {
                mapToFlowerDto(it)
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

    override suspend fun reduceFlowersNumber(flower: FlowersType, inequality: Int) =
        withContext(Dispatchers.IO) { localDataSource.reduceFlowersNumber(flower, inequality) }

}