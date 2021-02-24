package com.marvel.characters.model.character


import com.google.gson.annotations.SerializedName

data class SeriesRes(
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String
)