package com.marvel.characters.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.characters.databinding.CharacterCardBinding
import com.marvel.characters.databinding.ComicCardBinding
import com.marvel.characters.list.viewholder.CharacterViewHolder
import com.marvel.characters.list.viewholder.ComicViewHolder
import com.marvel.characters.model.comic.Comic

class ComicAdapter(private val items: List<Comic>) : RecyclerView.Adapter<ComicViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val binding = ComicCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComicViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.bind(items[position])
    }


}