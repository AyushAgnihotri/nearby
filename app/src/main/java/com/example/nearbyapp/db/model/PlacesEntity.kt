package com.example.nearbyapp.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PlacesEntity(
    @PrimaryKey
    var id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("display_location")
    val display_location: String?
)
