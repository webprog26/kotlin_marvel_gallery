package com.example.kotlinmarvelgallery.helpers

import com.example.kotlinmarvelgallery.model.MarvelCharacter

object Example {

    val exampleCharacter = MarvelCharacter("ExampleName", "ExampleImageUrl")
    val exampleCharacterList = listOf(
        exampleCharacter,
        MarvelCharacter("Name1", "ImageUrl1"),
        MarvelCharacter("Name2", "ImageUrl2")
    )
}