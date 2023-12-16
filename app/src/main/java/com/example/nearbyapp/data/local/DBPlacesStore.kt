package com.example.nearbyapp.data.local

import com.example.nearbyapp.data.remote.response.Place
import com.example.nearbyapp.db.dao.PlacesDao
import com.example.nearbyapp.db.model.PlacesEntity


class DBPlacesStore(
    private val placesDao: PlacesDao,
) : PlacesStore {
    override suspend fun getAllPlaces(): List<Place> {
        return placesDao.getAll().map { Place(it.id, it.name, it.display_location) }
    }

    override suspend fun saveAllPlaces(places: List<Place>) {
        val PlacesEntityList =
            places.map {
                PlacesEntity(it.id, it.name ?: "", it.display_location)
            }
        return placesDao.insertAll(PlacesEntityList)
    }
}
