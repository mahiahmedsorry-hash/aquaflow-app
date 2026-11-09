package com.aquaflow.app.data.local
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WaterEntry::class], version = 1, exportSchema = false)
abstract class AquaflowDatabase : RoomDatabase() {
    abstract fun waterDao(): WaterDao

    companion object {
        @Volatile
        private var INSTANCE: AquaflowDatabase? = null
        fun getDatabase(context: Context): AquaflowDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AquaflowDatabase::class.java,
                    "aquaflow_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
