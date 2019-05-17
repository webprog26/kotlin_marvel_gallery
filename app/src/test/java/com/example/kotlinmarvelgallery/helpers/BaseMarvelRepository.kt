package com.example.kotlinmarvelgallery.helpers

import com.example.kotlinmarvelgallery.data.MarvelRepository
import com.example.kotlinmarvelgallery.model.MarvelCharacter
import io.reactivex.Single

class BaseMarvelRepository (
    val onGetCharacters: () -> Single<List<MarvelCharacter>>
) : MarvelRepository {

    override fun getAllCharacters(serachQuery: String?): Single<List<MarvelCharacter>> {
        return onGetCharacters()
    }
}