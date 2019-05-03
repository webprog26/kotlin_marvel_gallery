package com.example.kotlinmarvelgallery.view.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Window
import com.example.kotlinmarvelgallery.R
import com.example.kotlinmarvelgallery.data.MarvelRepository
import com.example.kotlinmarvelgallery.model.MarvelCharacter
import com.example.kotlinmarvelgallery.presenter.MainPresenter
import com.example.kotlinmarvelgallery.view.common.BaseActivityWithPresenter
import com.example.kotlinmarvelgallery.view.common.bindToSwipeRefresh
import com.example.kotlinmarvelgallery.view.common.toast
import    kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivityWithPresenter(), MainView {

    override var refresh by bindToSwipeRefresh(R.id.swipe_refresh_view)
    override val presenter by lazy { MainPresenter(this, MarvelRepository.get()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = GridLayoutManager(this, 2)
        swipe_refresh_view.setOnRefreshListener { presenter.onRefresh() }
        presenter.onViewCreated()

    }

    override fun show(items: List<MarvelCharacter>) {
        val categoryItemsAdapters = items.map(::CharacterItemdapter)
        recycler_view.adapter = MainListAdapter(categoryItemsAdapters)
    }

    override fun showError(error: Throwable) {
        toast("Error:	${error.message}")    //	2
        error.printStackTrace()
    }
}
