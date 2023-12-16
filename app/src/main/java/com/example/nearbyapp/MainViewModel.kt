package com.example.nearbyapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nearbyapp.repository.NearbyPlacesRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel
@Inject
constructor(
    private val nearbyPlacesRepository: NearbyPlacesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PlacesViewState>(PlacesViewState.Loading)

    private val exceptionHandler =
        CoroutineExceptionHandler { _, th ->
            _uiState.value = PlacesViewState.Error(th)
        }

    val uiState = _uiState.asStateFlow()

    init {
        fetchPlaces()
    }

    fun fetchPlaces() {
        viewModelScope.launch(exceptionHandler) {
            nearbyPlacesRepository.getNearbyPlaces().onFailure {
                _uiState.value = PlacesViewState.Error(it)
            }.onSuccess {placesResponse ->
                _uiState.value = PlacesViewState.Success(placesResponse.venues.toTypedArray())
            }
        }
    }



}