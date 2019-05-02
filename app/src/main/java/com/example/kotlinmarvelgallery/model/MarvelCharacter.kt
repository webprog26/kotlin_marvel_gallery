package com.example.kotlinmarvelgallery.model

import com.example.kotlinmarvelgallery.dto.CharacterMarvelDto

data class MarvelCharacter (
    val name: String,
    val imageUrl: String
) {
    constructor(dto: CharacterMarvelDto): this (
        name = dto.name,
        imageUrl = dto.imageUrl

    )
}