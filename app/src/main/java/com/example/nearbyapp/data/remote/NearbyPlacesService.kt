package com.example.nearbyapp.data.remote

import com.example.nearbyapp.data.remote.response.PlacesResponse
import retrofit2.http.Query

interface NearbyPlacesService {

    suspend fun fetchPlaces(
        clientId: String,
        page: Int,
        lat: String,
        lon: String,
        range: String
    ): Result<PlacesResponse>
}
