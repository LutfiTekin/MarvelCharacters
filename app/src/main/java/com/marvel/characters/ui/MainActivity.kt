package com.marvel.characters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.marvel.characters.CharactersViewModel
import com.marvel.characters.databinding.ActivityMainBinding
import com.marvel.characters.list.adapter.CharacterAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val charactersViewModel: CharactersViewModel by lazy {
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    private val characterAdapter = CharacterAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.recyclerView.adapter = characterAdapter
        lifecycleScope.launch {
            charactersViewModel.charactersFlow.collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }




}