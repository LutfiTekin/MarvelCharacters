package com.marvel.characters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ImageViewCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.marvel.characters.datasource.CharacterApi
import com.marvel.characters.datasource.CharacterPagingSource
import com.marvel.characters.list.adapter.CharacterAdapter
import com.marvel.characters.service.PAGE_LIMIT
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val charactersViewModel: CharactersViewModel by lazy {
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }

    private var list: RecyclerView? = null

    private val pagedAdapter = CharacterAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById<RecyclerView>(R.id.list)
        list?.adapter = pagedAdapter
        val source = CharacterApi()
        val paged = Pager(PagingConfig(PAGE_LIMIT)){
            CharacterPagingSource(source)
        }.flow.cachedIn(lifecycleScope)
        lifecycleScope.launch {
            paged.collectLatest {
                pagedAdapter.submitData(it)
            }
        }
    }




}