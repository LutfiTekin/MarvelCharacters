package com.marvel.characters.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.marvel.characters.databinding.ComicCardBinding
import com.marvel.characters.model.comic.Comic

class ComicViewHolder internal constructor(
    private val binding: ComicCardBinding): RecyclerView.ViewHolder(binding.root)  {


        fun bind(data: Comic?){
            val comic = data ?: return
            with(binding){
                image.load(comic.thumbnail.image)
                name.text = comic.title
            }
        }

}
