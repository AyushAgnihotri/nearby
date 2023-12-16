package com.example.nearbyapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nearbyapp.db.dao.PlacesDao
import com.example.nearbyapp.db.model.PlacesEntity

@Database(entities = [PlacesEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun placesDao(): PlacesDao


    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) =
            instance ?: synchronized(LOCK) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context = context,
                klass = AppDatabase::class.java,
                name = "app_db",
            ).build()
    }
}
