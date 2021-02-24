package com.marvel.characters.list.comparator

import androidx.recyclerview.widget.DiffUtil
import com.marvel.characters.model.character.Character
import kotlin.Exception

object CharacterComparator : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return try {
            oldItem == newItem
        }catch (e: Exception){
            false
        }
    }
}