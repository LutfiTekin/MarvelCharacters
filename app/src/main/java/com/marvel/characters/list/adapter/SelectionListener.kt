package com.marvel.characters.list.adapter

import com.marvel.characters.model.character.Character

interface SelectionListener {

    fun onCharacterSelected(character: Character)

}