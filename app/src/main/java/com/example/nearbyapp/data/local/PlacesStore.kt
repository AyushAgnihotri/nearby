package com.example.nearbyapp.data.local

import com.example.nearbyapp.data.remote.response.Place


interface PlacesStore {
    suspend fun getAllPlaces(): List<Place>

    suspend fun saveAllPlaces(places: List<Place>)
}
