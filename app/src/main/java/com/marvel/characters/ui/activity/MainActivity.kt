package com.marvel.characters.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.marvel.characters.ui.viewmodel.CharactersViewModel
import com.marvel.characters.databinding.ActivityMainBinding
import com.marvel.characters.list.adapter.CharacterAdapter
import com.marvel.characters.list.adapter.SelectionListener
import com.marvel.characters.model.character.Character
import com.marvel.characters.ui.fragment.CharacterDetail
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), SelectionListener {

    private val charactersViewModel: CharactersViewModel by lazy {
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    private val characterAdapter = CharacterAdapter(this)


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
        charactersViewModel.selectedCharacter.observe(this, {  character ->
            character?.let {
                CharacterDetail().show(supportFragmentManager,"cd")
            }
        })
    }

    override fun onCharacterSelected(character: Character) {
        charactersViewModel.selectedCharacter.value = character
    }
}