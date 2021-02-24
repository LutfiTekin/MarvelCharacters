package com.marvel.characters.datasource

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.marvel.characters.generateHash
import com.marvel.characters.model.character.Character
import com.marvel.characters.service.MarvelService
import com.marvel.characters.service.PAGE_LIMIT
import com.marvel.characters.utils.defaultRetrofit

class CharacterApi() {
    var page = 0

    suspend fun getCharacters(requestedPage: Int): List<Character>?{
        page = requestedPage
        val service = defaultRetrofit.create(MarvelService::class.java)
        Log.d("MRVL","get characters ${defaultRetrofit.baseUrl()}")
        val now = System.currentTimeMillis()
        val hash = now.generateHash()
        val publicKey = Firebase.remoteConfig.getString("public_key")
        val offset = page * PAGE_LIMIT
        val characters = service.getCharacters(publicKey,hash,now, PAGE_LIMIT,offset)
        characters.body()?.let {  characterResult ->
            return characterResult.data.results
        }
        return null
    }
}