package com.example.kotlinmarvelgallery

import com.example.kotlinmarvelgallery.helpers.BaseMainView
import com.example.kotlinmarvelgallery.helpers.BaseMarvelRepository
import com.example.kotlinmarvelgallery.helpers.Example
import com.example.kotlinmarvelgallery.model.MarvelCharacter
import com.example.kotlinmarvelgallery.presenter.MainPresenter
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun `After view was created, list of characters is loaded and displayed`() {
        assertOnAction { onViewCreated() }.thereIsSameListDisplayed()
    }

    @Test
    fun `New list is shown after view was refreshed`() {
        assertOnAction { onRefresh() }.thereIsSameListDisplayed()
    }

    @Test
    fun `When API returns error, it is displayed on view`() {
        // Given
        val someError = Error()
        var errorDisplayed: Throwable? = null
        val view = BaseMainView(
            onShow = { _ -> fail() },
            onShowError = { errorDisplayed = it }
        )
        val marvelRepository = BaseMarvelRepository { Single.error(someError) }
        val mainPresenter = MainPresenter(view, marvelRepository)
        // When
        mainPresenter.onViewCreated()
        // Then
        assertEquals(someError, errorDisplayed)
    }

    @Test
    fun `When presenter is waiting for response, refresh is displayed`() {
        // Given
        val view = BaseMainView(refresh = false)
        val marvelRepository = BaseMarvelRepository(
            onGetCharacters = {
                Single.fromCallable {
                    // Then
                    assertTrue(view.refresh) // 1
                    Example.exampleCharacterList
                }
            }
        )
        val mainPresenter = MainPresenter(view, marvelRepository)
        view.onShow = { _ ->
            // Then
            assertTrue(view.refresh) // 1
        }
        // When
        mainPresenter.onViewCreated()
        // Then
        assertFalse(view.refresh) // 1
    }


    private fun assertOnAction(action: MainPresenter.() -> Unit)
            = PresenterActionAssertion(action)

    private class PresenterActionAssertion(val actionOnPresenter: MainPresenter.() -> Unit) {

        fun thereIsSameListDisplayed() {
            // Given
            var displayedList: List<MarvelCharacter>? = null

            val view = BaseMainView(
                onShow = { items -> displayedList = items },
                onShowError = { fail() }
            )
            val marvelRepository = BaseMarvelRepository(
                onGetCharacters = { Single.just(Example.exampleCharacterList) }
            )

            val mainPresenter = MainPresenter(view, marvelRepository)

            // When
            mainPresenter.actionOnPresenter()

            // Then
            assertEquals(Example.exampleCharacterList, displayedList)
        }
    }
}