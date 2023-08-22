package ru.nb.search_presenter

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchScreen(
	paddingValues: PaddingValues,
	viewModel: SearchViewModel = hiltViewModel()
) {

	val state = viewModel.state
	val onEvent = viewModel::onEvent

	SearchView(
		paddingValues = paddingValues,
		state = state,
		onEvent = onEvent
	)
}