package com.marvel.characters.model.comic

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<StoryItem>,
    val returned: Int
)