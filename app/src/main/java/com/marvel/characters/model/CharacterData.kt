package com.marvel.characters.model


import com.google.gson.annotations.SerializedName
import com.marvel.characters.model.character.Character

data class CharacterData(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val total: Int,
    val results: List<Character>
)