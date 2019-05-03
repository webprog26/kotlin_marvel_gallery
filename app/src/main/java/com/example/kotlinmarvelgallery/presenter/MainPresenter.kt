package com.example.kotlinmarvelgallery.presenter

import com.example.kotlinmarvelgallery.data.MarvelRepository
import com.example.kotlinmarvelgallery.view.common.applySchedulers
import com.example.kotlinmarvelgallery.view.common.plusAssign
import com.example.kotlinmarvelgallery.view.common.subscribeBy
import com.example.kotlinmarvelgallery.view.main.MainView


class MainPresenter(val view: MainView, val repository: MarvelRepository) : BasePresenter() {

    fun onViewCreated() {
        loadCharacters()
    }

    fun onRefresh() {
        loadCharacters()
    }

    private fun loadCharacters() {
        subscriptions += repository.getAllCharacters()
            .applySchedulers()
            .doOnSubscribe { view.refresh = true }
            .doFinally { view.refresh = false }.subscribeBy(
                onSuccess = view::show,
                onError = view::showError
            )
    }
}