package com.marvel.characters.datasource

import com.marvel.characters.model.character.Character
import com.marvel.characters.network.MarvelService
import com.marvel.characters.network.CHARACTER_PAGE_LIMIT
import com.marvel.characters.utils.defaultRetrofit

class CharacterApi() {
    var page = 0

    private val service = defaultRetrofit.create(MarvelService::class.java)

    suspend fun getCharacters(requestedPage: Int): List<Character>?{
        page = requestedPage
        val offset = page * CHARACTER_PAGE_LIMIT
        val characters = service.getCharacters(CHARACTER_PAGE_LIMIT,offset)
        characters.body()?.let {  characterResult ->
            return characterResult.data.results
        }
        return null
    }
}