package com.example.nearbyapp.data.remote.api

import com.example.nearbyapp.data.remote.response.PlacesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NearbyAPI {
    @GET("2/venues")
    suspend fun fetchPlaces(
        @Query("per_page") per_page: Int = 10,
        @Query("page") page: Int,
        @Query("client_id") client_id: String,
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("range") range: String,
    ): Response<PlacesResponse>

}
