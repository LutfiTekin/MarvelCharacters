package com.marvel.characters

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.marvel.characters.datasource.CharacterApi
import com.marvel.characters.datasource.CharacterPagingSource
import com.marvel.characters.model.character.Character
import com.marvel.characters.service.MarvelService
import com.marvel.characters.service.PAGE_LIMIT
import com.marvel.characters.utils.defaultRetrofit
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharactersViewModel: ViewModel() {



    fun loadCharacters(loaded: (PagingData<Character>) -> Unit){
        val source = CharacterApi()
        val paged = Pager(PagingConfig(PAGE_LIMIT)){
            CharacterPagingSource(source)
        }.flow.cachedIn(viewModelScope)
        viewModelScope.launch {
            paged.collectLatest {
                loaded(it)
            }
        }
    }

}