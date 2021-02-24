package com.marvel.characters.model


import com.google.gson.annotations.SerializedName
import com.marvel.characters.model.character.Character

data class CharacterData(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("total")
    val total: Int,
    val results: List<Character>
)