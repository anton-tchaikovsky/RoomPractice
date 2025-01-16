package com.example.roompractice.data.data_source

import com.example.roompractice.com.example.roompractice.data.room.dao.BouquetDao
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersType
import com.example.roompractice.data.room.FlowersDatabase
import com.example.roompractice.data.room.dao.FlowersDao
import com.example.roompractice.data.room.entity.Bouquet
import com.example.roompractice.data.room.entity.Flower
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(database: FlowersDatabase): LocalDataSource {

    private val flowersDao: FlowersDao = database.flowersDao()

    private val bouquetsDao: BouquetDao = database.bouquetsDao()

    override suspend fun getFlowers(): List<Flower> =
        flowersDao.getFlowers()

    override suspend fun getBouquets(): List<Bouquet> =
        bouquetsDao.getBouquets()

    override suspend fun getBouquet(name: String): Bouquet? =
        bouquetsDao.getBouquetsByName(name)

    override suspend fun reduceFlowersNumber(flower: FlowersType, inequality: Int) =
        flowersDao.reduceFlowersNumber(flower, inequality)
}