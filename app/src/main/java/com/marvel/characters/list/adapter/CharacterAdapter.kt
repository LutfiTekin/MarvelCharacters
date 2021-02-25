package com.marvel.characters.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.marvel.characters.R
import com.marvel.characters.databinding.CharacterCardBinding
import com.marvel.characters.list.comparator.CharacterComparator
import com.marvel.characters.list.viewholder.CharacterViewHolder
import com.marvel.characters.model.character.Character

class CharacterAdapter(private val listener: SelectionListener) : PagingDataAdapter<Character, CharacterViewHolder>(CharacterComparator){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding,listener)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

