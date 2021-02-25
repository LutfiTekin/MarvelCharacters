package com.marvel.characters.model

import com.marvel.characters.model.comic.Comic

data class ComicData(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Comic>,
    val total: Int
)