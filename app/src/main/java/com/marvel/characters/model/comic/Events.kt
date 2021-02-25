package com.marvel.characters.model.comic

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)