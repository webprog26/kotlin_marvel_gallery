package com.example.kotlinmarvelgallery.view.common

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

open class RecyclerListAdapter(
    var items: List<AnyItemAdapter> = listOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    final override fun getItemCount(): Int {
        return items.size
    }

    final override fun getItemViewType(position: Int): Int {
        return items[position].layoutId
    }

    final override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)
        return items.first { it.layoutId == layoutId }.onCreateViewHolder(itemView)
    }

    final override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        items[position].bindViewHolder(holder)
    }
}

typealias AnyItemAdapter = ItemAdapter<out RecyclerView.ViewHolder>