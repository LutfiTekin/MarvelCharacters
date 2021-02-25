package com.marvel.characters.model


import com.google.gson.annotations.SerializedName

data class CharacterResult(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val status: String,
    val data: CharacterData
)