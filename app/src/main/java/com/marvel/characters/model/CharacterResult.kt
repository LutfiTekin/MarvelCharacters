package com.marvel.characters.model


import com.google.gson.annotations.SerializedName

data class CharacterResult(
    @SerializedName("attributionHTML")
    val attributionHTML: String,
    @SerializedName("attributionText")
    val attributionText: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("status")
    val status: String,
    val data: CharacterData
)