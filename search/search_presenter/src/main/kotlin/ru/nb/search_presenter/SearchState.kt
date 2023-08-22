package ru.nb.search_presenter

import ru.nb.search_domain.model.BaseUi

data class SearchState(
	val baseUiList: List<BaseUi> = emptyList(),
	val searchText: String = "",

	val favoritePeoplesUrls: List<String> = emptyList(),
	val favoriteStarshipsUrls: List<String> = emptyList(),
	val favoritePlanetsUrls: List<String> = emptyList(),

	val isLoading: Boolean = false,
	val isError: Boolean = false,
)
