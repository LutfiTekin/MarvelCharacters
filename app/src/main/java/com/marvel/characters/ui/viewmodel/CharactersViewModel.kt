package com.marvel.characters.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.marvel.characters.datasource.CharacterApi
import com.marvel.characters.datasource.CharacterPagingSource
import com.marvel.characters.model.character.Character
import com.marvel.characters.network.PAGE_LIMIT
import kotlinx.coroutines.flow.Flow

class CharactersViewModel: ViewModel() {

    private val source = CharacterApi()

    val charactersFlow : Flow<PagingData<Character>>
        get() {
            return Pager(PagingConfig(PAGE_LIMIT)){
                CharacterPagingSource(source)
            }.flow.cachedIn(viewModelScope)
        }


}