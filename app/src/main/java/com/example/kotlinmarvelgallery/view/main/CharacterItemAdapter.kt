package com.example.kotlinmarvelgallery.view.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlinmarvelgallery.R
import com.example.kotlinmarvelgallery.model.MarvelCharacter
import com.example.kotlinmarvelgallery.view.common.ItemAdapter
import com.example.kotlinmarvelgallery.view.common.bindView
import com.example.kotlinmarvelgallery.view.common.loadImage

class CharacterItemAdapter(
    val character: MarvelCharacter,
    val clicked: (MarvelCharacter) -> Unit
) : ItemAdapter<CharacterItemAdapter.ViewHolder>(R.layout.item_character) {

    override fun onCreateViewHolder(itemView: View): CharacterItemAdapter.ViewHolder {
        return ViewHolder(itemView)
    }

    override fun ViewHolder.onBindViewHolder() {
        textView.text = character.name
        imageView.loadImage(character.imageUrl)
        itemView.setOnClickListener { clicked(character) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView by bindView<TextView>(R.id.text_view)
        val imageView by bindView<ImageView>(R.id.image_view)
    }
}