package com.marvel.characters.model.character


import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<SeriesRes>,
    @SerializedName("returned")
    val returned: Int
)