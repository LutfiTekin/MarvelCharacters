package com.marvel.characters.model.character


import com.google.gson.annotations.SerializedName

data class ComicRes(
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String
)