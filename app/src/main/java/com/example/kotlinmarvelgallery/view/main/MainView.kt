package com.example.kotlinmarvelgallery.view.main

import com.example.kotlinmarvelgallery.model.MarvelCharacter

interface MainView {

    var refresh: Boolean
    fun show(items: List<MarvelCharacter>)
    fun showError(error: Throwable)
}