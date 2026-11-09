package com.aquaflow.app.data.local
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WaterDao {
    @Insert
    suspend fun insertWater(entry: WaterEntry)

    @Query("SELECT SUM(amountMl) FROM water_entries")
    fun getTotalWaterToday(): Flow<Int?>

    @Query("DELETE FROM water_entries ORDER BY timestamp DESC LIMIT 1")
    suspend fun undoLastEntry()
}
