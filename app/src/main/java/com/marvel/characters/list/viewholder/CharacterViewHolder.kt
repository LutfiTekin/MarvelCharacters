package com.marvel.characters.list.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.marvel.characters.R
import com.marvel.characters.databinding.CharacterCardBinding
import com.marvel.characters.list.adapter.SelectionListener
import com.marvel.characters.model.character.Character

class CharacterViewHolder internal constructor(
    private val binding: CharacterCardBinding,
    private val listener: SelectionListener
) : RecyclerView.ViewHolder(binding.root) {


    private lateinit var loadedCharacter: Character
    init {
        binding.card.setOnClickListener {
            if (::loadedCharacter.isInitialized)
                listener.onCharacterSelected(loadedCharacter)
        }
    }

    fun bind(data: Character?){
        val character = data ?: return
        loadedCharacter = character
        with(binding){
            image.load(character.thumbnail.image)
            name.text = character.name
        }
    }


}