package com.example.kotlinmarvelgallery.data

import com.example.kotlinmarvelgallery.model.MarvelCharacter
import com.example.kotlinmarvelgallery.retrofit.MarvelApi
import com.example.kotlinmarvelgallery.retrofit.retrofit
import io.reactivex.Single

class MarvelRepositoryImpl : MarvelRepository {

    val api = retrofit.create(MarvelApi::class.java)

    override fun getAllCharacters(): Single<List<MarvelCharacter>> = api.getCharacters(
        offset = 0,
        limit = elementsOnListLimit
    ).map {
        it.data?.results.orEmpty().map(::MarvelCharacter) ?: emptyList()
    }

    companion object	{
        const val elementsOnListLimit =	50
    }
}