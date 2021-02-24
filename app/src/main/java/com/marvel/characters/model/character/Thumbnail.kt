package com.marvel.characters.model.character


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    val extension: String,
    @SerializedName("path")
    val path: String
){

    val image: String get() = "$path.$extension"

}