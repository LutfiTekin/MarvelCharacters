package com.marvel.characters.datasource

import android.util.Log
import com.marvel.characters.model.character.Character
import com.marvel.characters.service.MarvelService
import com.marvel.characters.service.PAGE_LIMIT
import com.marvel.characters.utils.defaultRetrofit

class CharacterApi() {
    var page = 0

    private val service = defaultRetrofit.create(MarvelService::class.java)

    suspend fun getCharacters(requestedPage: Int): List<Character>?{
        page = requestedPage
        val offset = page * PAGE_LIMIT
        val characters = service.getCharacters(PAGE_LIMIT,offset)
        characters.body()?.let {  characterResult ->
            return characterResult.data.results
        }
        return null
    }
}