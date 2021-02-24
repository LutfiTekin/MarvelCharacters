package com.marvel.characters.model.character


import com.google.gson.annotations.SerializedName

data class Stories(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<StoryRes>,
    @SerializedName("returned")
    val returned: Int
)