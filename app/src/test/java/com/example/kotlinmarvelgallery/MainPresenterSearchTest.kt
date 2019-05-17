//@file:Suppress("IllegalIdentifier")
//
//package com.example.kotlinmarvelgallery
//
//import com.example.kotlinmarvelgallery.helpers.BaseMainView
//import com.example.kotlinmarvelgallery.helpers.BaseMarvelRepository
//import com.example.kotlinmarvelgallery.presenter.MainPresenter
//import io.reactivex.Single
//import org.junit.Assert.*
//import org.junit.Test
//
//class MainPresenterSearchTest {
//
//    @Test
//    fun `When view is created, then search query is null`() {
//        assertOnAction { onViewCreated() } searchQueryIsEqualTo null
//    }
//
//    @Test
//    fun `When text is changed, then we are searching for new query`() {
//        for (text in listOf<String>("KKO", "HJ HJ", "And so what?"))
//            assertOnAction { onSearchChanged(text) }
//        searchQueryIsEqualTo text
//    }
//
//    @Test
//    fun `For blank text, there is request with null	query`() {
//        for (emptyText in listOf("", "	", "    "))
//            assertOnAction { onSearchChanged(emptyText) }
//            searchQueryIsEqualTo    null
//    }
//
//    private fun assertOnAction(action: MainPresenter.() -> Unit) {
//        PresenterActionAssertion(action)
//    }
//
//    private class PresenterActionAssertion(val actionOnPresenter: MainPresenter.() -> Unit) {
//
//        infix fun searchQueryIsEqualTo(expectedQuery: String?) {
//            var checkApplied = false
//            val view = BaseMainView(onShowError = { fail() })
//            val marvelRepository = BaseMarvelRepository { searchQuery ->
//                assertEquals(expectedQuery, searchQuery)
//                checkApplied = true
//                Single.never()
//            }
//
//            val mainPresenter = MainPresenter(view, marvelRepository)
//            mainPresenter.actionOnPresenter()
//            assertTrue(checkApplied)
//        }
//    }
//}