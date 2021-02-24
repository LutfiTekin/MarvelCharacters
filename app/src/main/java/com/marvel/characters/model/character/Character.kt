package com.marvel.characters.model.character


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("comics")
    val comics: Comic,
    @SerializedName("description")
    val description: String,
    @SerializedName("events")
    val events: Event,
    @SerializedName("id")
    val id: Int,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("series")
    val series: Series,
    @SerializedName("stories")
    val stories: Stories,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("urls")
    val urls: List<Url>
)