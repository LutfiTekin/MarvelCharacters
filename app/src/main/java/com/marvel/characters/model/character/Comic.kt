package com.marvel.characters.model.character


import com.google.gson.annotations.SerializedName

data class Comic(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicRes>,
    val returned: Int
)