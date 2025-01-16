package com.example.roompractice.com.example.roompractice.data.mapper

import com.example.roompractice.com.example.roompractice.data.room.entity.FlowersNumber
import com.example.roompractice.com.example.roompractice.domain.entity.BouquetDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowerDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersDescriptionDto
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersType
import com.example.roompractice.data.room.entity.Bouquet
import com.example.roompractice.data.room.entity.Flower

fun mapToFlowersDescriptionDto(flower: Flower): FlowersDescriptionDto = flower.flower

fun mapToBouquetDto(bouquet: Bouquet?): BouquetDto? =
    bouquet?.let {
        BouquetDto(
            name = bouquet.name,
            flowers = extractFlowers(bouquet.flowersNumber),
            design = bouquet.design
        )
    }

fun mapFromFlowersDto(flowers: List<FlowerDto>): Map<FlowersType, Int>{
    val flowersMap = mutableMapOf<FlowersType, Int>()
    flowers.forEach {
        flowersMap[it.flower] = it.number
    }
    return flowersMap
}

private fun extractFlowers(flowersNumber: FlowersNumber): List<FlowerDto> {
    val flowers = mutableListOf<FlowerDto>()
    FlowersType.entries.forEach {
        when (it) {
            FlowersType.ROSE ->
                if (flowersNumber.rose > 0) flowers.add(FlowerDto(it, flowersNumber.rose))

            FlowersType.LILY ->
                if (flowersNumber.lily > 0) flowers.add(FlowerDto(it, flowersNumber.lily))

            FlowersType.PEONY ->
                if (flowersNumber.peony > 0) flowers.add(FlowerDto(it, flowersNumber.peony))

            FlowersType.TULIP ->
                if (flowersNumber.tulip > 0) flowers.add(FlowerDto(it, flowersNumber.tulip))

            FlowersType.ORCHID ->
                if (flowersNumber.orchid > 0) flowers.add(FlowerDto(it, flowersNumber.orchid))

            FlowersType.ASTER ->
                if (flowersNumber.aster > 0) flowers.add(FlowerDto(it, flowersNumber.aster))

            FlowersType.CHRYSANTHEMUM ->
                if (flowersNumber.chrysanthemum > 0) flowers.add(
                    FlowerDto(
                        it,
                        flowersNumber.chrysanthemum
                    )
                )

            FlowersType.CARNATION ->
                if (flowersNumber.carnation > 0) flowers.add(FlowerDto(it, flowersNumber.carnation))

            FlowersType.IRIS ->
                if (flowersNumber.iris > 0) flowers.add(FlowerDto(it, flowersNumber.iris))

            FlowersType.LILAC ->
                if (flowersNumber.lilac > 0) flowers.add(FlowerDto(it, flowersNumber.lilac))
        }
    }
    return flowers
}