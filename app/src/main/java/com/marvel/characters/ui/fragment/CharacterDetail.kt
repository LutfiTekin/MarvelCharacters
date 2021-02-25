package com.marvel.characters.ui.fragment

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.marvel.characters.R
import com.marvel.characters.databinding.DialogCharacterDetailBinding
import com.marvel.characters.list.adapter.ComicAdapter
import com.marvel.characters.ui.viewmodel.CharactersViewModel
import kotlinx.coroutines.launch


class CharacterDetail: BottomSheetDialogFragment() {

    private val charactersViewModel : CharactersViewModel by activityViewModels()

    private var _binding: DialogCharacterDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showCharacterInfo()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        //release selected character object
        charactersViewModel.selectedCharacter.value = null
    }



    private fun DialogCharacterDetailBinding.showCharacterInfo(){
        val character = charactersViewModel.selectedCharacter.value ?: kotlin.run {
            //Something's wrong, abort all
            dismissAllowingStateLoss()
            return
        }
        image.load(character.thumbnail.image)
        name.text = character.name
        description.text = character.description.ifBlank { getString(R.string.empty_state_description) }

        lifecycleScope.launch {
            val comicsList = charactersViewModel.getComics(character.id)
            comicsRV.adapter = ComicAdapter(comicsList)
        }
    }

}