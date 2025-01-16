package com.example.roompractice.com.example.roompractice.domain.interactor

import android.util.Log
import com.example.roompractice.com.example.roompractice.domain.entity.BouquetDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowerDto
import com.example.roompractice.domain.Repository
import javax.inject.Inject

class InteractorImpl @Inject constructor(private val repository: Repository) : Interactor {
    override suspend fun getFlowers(): List<FlowerDto> = repository.getFlowers()

    override suspend fun getBouquets(): List<BouquetDto> = repository.getBouquets()

    override suspend fun getAvailableBouquets(): List<BouquetDto> {
        val bouquets = getBouquets().toMutableList()
        return bouquets.filter {
            isAvailableBouquet(it)
        }
    }

    private suspend fun isAvailableBouquet(bouquet: BouquetDto): Boolean {
        val flowers = getFlowers()
        return bouquet.flowers.all { flower ->
            flower.number <= (flowers.find { flower.flower == it.flower }?.number ?: 0)
        }
    }

    override suspend fun buyBouquet(name: String) {
        repository.getBouquet(name).let { bouquet ->
            if(bouquet!=null && isAvailableBouquet(bouquet)){
                bouquet.flowers.forEach {
                    repository.reduceFlowersNumber(it.flower, it.number)
                }
            } else
                Log.d ("@@@", "bouquet not available")
        }
    }
}