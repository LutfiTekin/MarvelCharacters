package com.marvel.characters.model.comic

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<CreatorItem>,
    val returned: Int
)