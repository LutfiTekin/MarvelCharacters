package com.marvel.characters.network

import com.marvel.characters.model.CharacterResult
import com.marvel.characters.model.ComicResult
import com.marvel.characters.model.character.Character
import com.marvel.characters.model.comic.Comic
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://gateway.marvel.com/v1/public/"
const val CHARACTER_PAGE_LIMIT = 30
const val COMIC_PAGE_LIMIT = 10

interface MarvelService {


    @GET("characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<CharacterResult>

    @GET("characters/{characterId}")
    suspend fun getCharacter(@Path("characterId") character: String): Response<Character>

    @GET("characters/{characterId}/comics?orderBy=-onsaleDate&limit=$COMIC_PAGE_LIMIT")
    suspend fun getComics(@Path("characterId") id: Int, @Query("dateRange") dateRange: String): Response<ComicResult>

}