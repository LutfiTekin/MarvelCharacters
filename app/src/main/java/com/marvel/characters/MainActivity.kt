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
import com.marvel.characters.databinding.ActivityMainBinding
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

    private lateinit var binding: ActivityMainBinding

    private val pagedAdapter = CharacterAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.list.adapter = pagedAdapter
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