package ru.nb.search_presenter

import ru.nb.search_domain.model.BaseUi

data class SearchState(
	val baseUiList: List<BaseUi> = emptyList(),
	val isLoading: Boolean = false,
	val isError: Boolean = false,
)
