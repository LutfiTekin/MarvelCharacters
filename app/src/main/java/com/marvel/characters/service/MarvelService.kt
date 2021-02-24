package com.marvel.characters.service

import com.marvel.characters.model.CharacterResult
import com.marvel.characters.model.character.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://gateway.marvel.com/v1/public/"
const val PAGE_LIMIT = 30

interface MarvelService {


    @GET("characters")
    suspend fun getCharacters(
        @Query("apikey") api: String,
        @Query("hash") hash: String,
        @Query("ts") timeStamp: Long,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<CharacterResult>

    @GET("characters/{characterId}")
    suspend fun getCharacter(@Path("characterId") character: String): Response<Character>


}