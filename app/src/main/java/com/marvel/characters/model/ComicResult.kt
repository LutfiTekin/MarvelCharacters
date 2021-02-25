package com.marvel.characters.model

data class ComicResult(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: ComicData,
    val etag: String,
    val status: String
)