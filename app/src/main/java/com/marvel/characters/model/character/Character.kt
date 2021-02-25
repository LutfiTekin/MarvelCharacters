package com.marvel.characters.model.character

import com.marvel.characters.model.Thumbnail


data class Character(
    val comics: CharacterComic,
    val description: String,
    val events: Event,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)