package com.example.nearbyapp

import com.example.nearbyapp.data.remote.response.Place

sealed class PlacesViewState {

    data object Loading : PlacesViewState()

    data object RemoteFetching : PlacesViewState()

    data class Error(
        val error: Throwable?,
    ) : PlacesViewState()

    data class Success(
        val places: Array<Place>,
    ) : PlacesViewState() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Success

            return places.contentEquals(other.places)
        }

        override fun hashCode(): Int {
            return places.contentHashCode()
        }
    }

}