package com.aquaflow.app.data.local
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "water_entries")
data class WaterEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val amountMl: Int,
    val timestamp: Long = System.currentTimeMillis()
)
