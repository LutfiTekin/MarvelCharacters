package com.marvel.characters.model.character


import com.google.gson.annotations.SerializedName

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<SeriesRes>,
    val returned: Int
)