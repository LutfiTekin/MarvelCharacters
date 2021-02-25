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
import com.marvel.characters.list.adapter.SelectionListener
import com.marvel.characters.model.character.Character

class CharacterViewHolder internal constructor(
    inflater: LayoutInflater,
    parent: ViewGroup,
    @LayoutRes res: Int,
    listener: SelectionListener
) : RecyclerView.ViewHolder(inflater.inflate(res, parent, false)) {

    private val card = itemView.findViewById<CardView>(R.id.card)
    private val image = itemView.findViewById<AppCompatImageView>(R.id.image)
    private val name = itemView.findViewById<AppCompatTextView>(R.id.name)

    private lateinit var loadedCharacter: Character
    init {
        card.setOnClickListener {
            if (::loadedCharacter.isInitialized)
                listener.onCharacterSelected(loadedCharacter)
        }
    }

    fun bind(data: Character?){
        val character = data ?: return
        loadedCharacter = character
        image.load(character.thumbnail.image)
        name.text = character.name
    }


}