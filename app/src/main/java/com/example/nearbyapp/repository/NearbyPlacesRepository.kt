package com.example.nearbyapp.repository

import com.example.nearbyapp.data.local.PlacesStore
import com.example.nearbyapp.data.remote.NearbyPlacesService
import com.example.nearbyapp.data.remote.response.PlacesResponse
import com.example.nearbyapp.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NearbyPlacesRepository
@Inject
constructor(
    val placesStore: PlacesStore,
    private val nearbyPlacesService: NearbyPlacesService
) {

    suspend fun getNearbyPlaces(
        page: Int = 1,
        lat: String = 12.971599.toString(),
        lon: String = 77.594566.toString(),
        range: String = "12mi"
    ): Result<PlacesResponse> {
        return withContext(Dispatchers.IO){
            nearbyPlacesService.fetchPlaces(
                clientId = Constants.CLIENT_ID,
                page,
                lat,
                lon,
                range
            )
        }
    }

}