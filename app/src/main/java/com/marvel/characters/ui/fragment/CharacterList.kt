package com.marvel.characters.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.marvel.characters.R
import com.marvel.characters.databinding.DialogCharacterDetailBinding
import com.marvel.characters.databinding.FragmentCharacterListBinding
import com.marvel.characters.list.adapter.CharacterAdapter
import com.marvel.characters.list.adapter.SelectionListener
import com.marvel.characters.model.character.Character
import com.marvel.characters.ui.viewmodel.CharactersViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class CharacterList : Fragment(), SelectionListener {

    private val viewModel: CharactersViewModel by activityViewModels()

    private var _binding: FragmentCharacterListBinding? = null

    private val characterAdapter = CharacterAdapter(this)

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = characterAdapter
        loadCharacters()
    }

    private fun loadCharacters(){
        lifecycleScope.launch {
            viewModel.charactersFlow.collectLatest {
                characterAdapter.submitData(it)
            }
        }
        viewModel.selectedCharacter.observe(viewLifecycleOwner, {  character ->
            character?.let {
                findNavController().navigate(R.id.characterDetail)
            }
        })
    }

    override fun onCharacterSelected(character: Character) {
        viewModel.selectedCharacter.value = character
    }

}