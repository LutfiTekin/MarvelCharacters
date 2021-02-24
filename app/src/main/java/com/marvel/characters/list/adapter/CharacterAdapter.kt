package com.marvel.characters.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.marvel.characters.R
import com.marvel.characters.list.comparator.CharacterComparator
import com.marvel.characters.list.viewholder.CharacterViewHolder
import com.marvel.characters.model.character.Character

class CharacterAdapter : PagingDataAdapter<Character, CharacterViewHolder>(CharacterComparator){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(LayoutInflater.from(parent.context),parent, R.layout.character_card)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}
