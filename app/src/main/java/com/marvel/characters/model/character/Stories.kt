package com.marvel.characters.model.character


import com.google.gson.annotations.SerializedName

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<StoryRes>,
    val returned: Int
)