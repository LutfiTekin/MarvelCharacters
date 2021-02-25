package com.marvel.characters.model.comic

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<ChracterItem>,
    val returned: Int
)