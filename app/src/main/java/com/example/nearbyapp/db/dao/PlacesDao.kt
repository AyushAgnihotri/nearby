package com.example.nearbyapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nearbyapp.db.model.PlacesEntity

@Dao
abstract class PlacesDao {
    @Query("SELECT * FROM PlacesEntity")
    abstract fun getAll(): List<PlacesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(placesEntityList: List<PlacesEntity>)
}
