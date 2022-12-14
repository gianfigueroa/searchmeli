package com.giancarlosfigueroa.searchmeli.feature_search.presentation.screen.search

sealed  class SearchEvent {
    data class EnteredSearch(val value: String): SearchEvent()
    data class PutError(val value: String): SearchEvent()

}