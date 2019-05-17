package com.example.kotlinmarvelgallery.data

import com.example.kotlinmarvelgallery.model.MarvelCharacter
import io.reactivex.Single

interface MarvelRepository {

    fun getAllCharacters(searchQuery: String?): Single<List<MarvelCharacter>>

    companion object: Provider<MarvelRepository>() {
        override fun creator(): MarvelRepository {
            return MarvelRepositoryImpl()
        }
    }
}