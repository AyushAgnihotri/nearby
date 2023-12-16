package com.example.nearbyapp.data.remote.response

data class PlacesResponse(
    val venues: List<Place>
)


data class Place(
    val id: Int,
    val name: String? = null,
    val display_location: String? = null
)