package com.marvel.characters.datasource


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.marvel.characters.model.character.Character
import com.marvel.characters.network.PAGE_LIMIT

class CharacterPagingSource(private val source: CharacterApi): PagingSource<Int,Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val requestedPage = params.key ?: 0
            val data = source.getCharacters(requestedPage) ?: emptyList()
            LoadResult.Page(data, if (requestedPage == 0) null else requestedPage - 1, if (data.size < PAGE_LIMIT) null else source.page + 1)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }
}