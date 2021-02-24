package com.marvel.characters.list.viewholder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.marvel.characters.R
import com.marvel.characters.model.character.Character

class CharacterViewHolder internal constructor(
    inflater: LayoutInflater,
    parent: ViewGroup,
    @LayoutRes res: Int
) : RecyclerView.ViewHolder(inflater.inflate(res, parent, false)) {

    private val image = itemView.findViewById<AppCompatImageView>(R.id.image)
    private val name = itemView.findViewById<AppCompatTextView>(R.id.name)

    fun bind(data: Character?){
        val character = data ?: return
        image.load(character.thumbnail.image.also {
            Log.d("MRVL","thumbnail $it")
        })
        name.text = character.name
    }


}