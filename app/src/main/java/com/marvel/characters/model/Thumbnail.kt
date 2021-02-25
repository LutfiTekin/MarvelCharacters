package com.marvel.characters.model


data class Thumbnail(
    val extension: String,
    val path: String
){

    val image: String get() = "$path.$extension"

}