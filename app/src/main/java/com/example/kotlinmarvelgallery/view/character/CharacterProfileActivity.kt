package com.example.kotlinmarvelgallery.view.character

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.kotlinmarvelgallery.R
import com.example.kotlinmarvelgallery.model.MarvelCharacter
import com.example.kotlinmarvelgallery.view.common.extra
import com.example.kotlinmarvelgallery.view.common.getIntent
import com.example.kotlinmarvelgallery.view.common.loadImage
import kotlinx.android.synthetic.main.activity_character_profile.*

class CharacterProfileActivity : AppCompatActivity() {

    val character: MarvelCharacter by extra(CHARACTER_ARG)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_profile)
        setupToolbar()
        supportActionBar?.title = character.name
        descriptionView.text = character.description
        occurrencesView.text = makeOccurencesText()
        headerView.loadImage(character.imageUrl, centerCropped = true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
        when {
            item?.itemId == android.R.id.home -> onBackPressed().let { true }
            else -> super.onOptionsItemSelected(item)
        }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {
        private const val bullet = '\u2022'
        private const val CHARACTER_ARG = "com.example.kotlinmarvelgallery.view.character.character_arg"

        fun start(context: Context, character: MarvelCharacter) {
            val intent = context.getIntent<CharacterProfileActivity>()
                .apply { putExtra(CHARACTER_ARG, character) }
            context.startActivity(intent)
        }
    }

    private fun makeOccurencesText(): String = ""
        .addList(R.string.occurrences_comics_list_introduction, character.comics)
        .addList(R.string.occurrences_series_list_introduction, character.series)
        .addList(R.string.occurrences_stories_list_introduction, character.stories)
        .addList(R.string.occurrences_events_list_introduction, character.events)

    private fun String.addList(introductionTextId: Int, list: List<String>): String {
        if (list.isEmpty()) return this
        val introductionText = getString(introductionTextId)
        val listText = list.joinToString(
            transform =
            { " $bullet $it" }, separator = "\n"
        )
        return this + "$introductionText\n$listText\n\n"
    }
}
