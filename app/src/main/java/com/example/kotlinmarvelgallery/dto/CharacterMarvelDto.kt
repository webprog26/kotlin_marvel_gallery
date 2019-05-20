package com.example.kotlinmarvelgallery.dto

class CharacterMarvelDto {

    lateinit var name: String
    lateinit var thumbnail: ImageDto
    lateinit var description: String

    var comics: ListWrapper<ComicDto> = ListWrapper()
    var series: ListWrapper<ComicDto> = ListWrapper()
    var stories: ListWrapper<ComicDto> = ListWrapper()
    var events: ListWrapper<ComicDto> = ListWrapper()

    val imageUrl: String
    get() = thumbnail.completeImagePath
}