package com.marvel.characters.model.character


import com.google.gson.annotations.SerializedName

data class Event(
    val available: Int,
    val collectionURI: String,
    val items: List<EventRes>,
    val returned: Int
)