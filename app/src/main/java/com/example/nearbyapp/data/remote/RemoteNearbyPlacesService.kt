package com.example.nearbyapp.data.remote

import com.example.nearbyapp.data.remote.api.NearbyAPI
import com.example.nearbyapp.data.remote.response.PlacesResponse

class RemoteNearbyPlacesService(
    private val nearbyAPI: NearbyAPI,
) : NearbyPlacesService {
    override suspend fun fetchPlaces(
        clientId: String,
        page: Int,
        lat: String,
        lon: String,
        range: String
    ): Result<PlacesResponse> {
        val response = nearbyAPI.fetchPlaces(
            page = page,
            client_id = clientId,
            lat = lat,
            lon = lon,
            range = range
        )
        return if (response.isSuccessful) {
            val body = response.body()
            if (body == null) {
                Result.failure(Throwable("Empty Body"))
            } else {
                Result.success(body)
            }
        } else {
            Result.failure(Throwable("Response is not successful"))
        }
    }
}
