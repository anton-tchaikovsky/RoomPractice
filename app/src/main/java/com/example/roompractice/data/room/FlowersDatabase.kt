package com.example.roompractice.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roompractice.com.example.roompractice.data.room.MIGRATION_1_2
import com.example.roompractice.com.example.roompractice.data.room.dao.BouquetDao
import com.example.roompractice.com.example.roompractice.domain.entity.FlowersType
import com.example.roompractice.data.room.dao.FlowersDao
import com.example.roompractice.data.room.entity.Bouquet
import com.example.roompractice.data.room.entity.Flower
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Flower::class, Bouquet::class],
    version = 2,
    exportSchema = true
)
@TypeConverters(value = [FlowersConverter::class])
abstract class FlowersDatabase : RoomDatabase() {
    abstract fun flowersDao(): FlowersDao

    abstract fun bouquetsDao(): BouquetDao

    companion object {

        private var flowersDatabase: FlowersDatabase? = null

        fun createFlowersDatabase(context: Context): FlowersDatabase =
            flowersDatabase ?: Room.databaseBuilder(
                context,
                FlowersDatabase::class.java,
                "flowersDatabase"
            )
                .createFromAsset("flowersDatabase.db")
                .addMigrations(MIGRATION_1_2)
                .build().also {
                    flowersDatabase = it
                    prepopulateDatabase(it)
                }

        private fun prepopulateDatabase(database: FlowersDatabase){
            CoroutineScope(Dispatchers.IO).launch {
                database.flowersDao().insertCountriesForFlowers(createFlowersCountriesMap())
            }
        }

        private fun createFlowersCountriesMap(): Map<FlowersType, String> {
            val flowersCountriesMap = mutableMapOf<FlowersType, String>()
            FlowersType.entries.forEach {
                when (it) {
                    FlowersType.ROSE -> flowersCountriesMap[it] = "Israel"
                    FlowersType.LILY -> flowersCountriesMap[it] = "Netherlands"
                    FlowersType.PEONY -> flowersCountriesMap[it] = "Israel"
                    FlowersType.TULIP -> flowersCountriesMap[it] = "Netherlands"
                    FlowersType.ORCHID -> flowersCountriesMap[it] = "France"
                    FlowersType.ASTER -> flowersCountriesMap[it] = "France"
                    FlowersType.CHRYSANTHEMUM -> flowersCountriesMap[it] = "France"
                    FlowersType.CARNATION -> flowersCountriesMap[it] = "Israel"
                    FlowersType.IRIS -> flowersCountriesMap[it] = "France"
                    FlowersType.LILAC -> flowersCountriesMap[it] = "Netherlands"
                }
            }
            return flowersCountriesMap
        }
    }
}