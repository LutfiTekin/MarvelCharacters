package com.marvel.characters.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.marvel.characters.datasource.CharacterApi
import com.marvel.characters.datasource.CharacterPagingSource
import com.marvel.characters.model.character.Character
import com.marvel.characters.model.comic.Comic
import com.marvel.characters.network.CHARACTER_PAGE_LIMIT
import com.marvel.characters.network.MarvelService
import com.marvel.characters.utils.dateRange
import com.marvel.characters.utils.defaultRetrofit
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.*

class CharactersViewModel: ViewModel() {

    val selectedCharacter = MutableLiveData<Character?>(null)

    private val source = CharacterApi()

    val charactersFlow : Flow<PagingData<Character>>
        get() {
            return Pager(PagingConfig(CHARACTER_PAGE_LIMIT)){
                CharacterPagingSource(source)
            }.flow.cachedIn(viewModelScope)
        }


    suspend fun getComics(character: Int): List<Comic>{
        return try {
            val response = defaultRetrofit.create(MarvelService::class.java)
                .getComics(character,dateRange)

            response.body()?.data?.results ?: throw Exception("Empty List")
        } catch (e: Exception) {
            Log.d("OkHttp","err ${e.message}")
            emptyList()
        }
    }

}