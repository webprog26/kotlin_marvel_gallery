package com.example.kotlinmarvelgallery.presenter

import com.example.kotlinmarvelgallery.data.MarvelRepository
import com.example.kotlinmarvelgallery.view.common.applySchedulers
import com.example.kotlinmarvelgallery.view.common.plusAssign
import com.example.kotlinmarvelgallery.view.common.smartSubscribe
import com.example.kotlinmarvelgallery.view.main.MainView


class MainPresenter(val view: MainView, val repository: MarvelRepository) : BasePresenter() {

    fun onViewCreated() {
        loadCharacters()
    }

    fun onRefresh() {
        loadCharacters()
    }

    fun onSearchChanged(text: String) {
        loadCharacters(text)
    }

    private	fun	loadCharacters(searchQuery:	String?	=	null)	{
        val	qualifiedSearchQuery	=	if	(searchQuery.isNullOrBlank())	null
        else	searchQuery
        subscriptions	+=	repository
            .getAllCharacters(qualifiedSearchQuery)
            .applySchedulers()
            .smartSubscribe(
                onStart	= {	view.refresh = true	},
                onSuccess =	view::show,
                onError	= view::showError,
                onFinish = { view.refresh =	false }
            )
    }
}