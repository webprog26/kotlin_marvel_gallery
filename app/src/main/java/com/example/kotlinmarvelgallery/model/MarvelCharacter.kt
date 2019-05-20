package com.example.kotlinmarvelgallery.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.example.kotlinmarvelgallery.dto.CharacterMarvelDto
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class MarvelCharacter (
    val name: String,
    val imageUrl: String,
    val description: String,
    val comics: List<String>,
    val series: List<String>,
    val stories: List<String>,
    val events: List<String>
) : Parcelable {
    constructor(dto: CharacterMarvelDto): this (
        name = dto.name,
        imageUrl = dto.imageUrl,
        description = dto.description,
        comics = dto.comics.items.map { it.name },
        series = dto.comics.items.map { it.name },
        stories = dto.comics.items.map { it.name },
        events = dto.comics.items.map { it.name }

    )
}