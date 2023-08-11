package ru.nb.starwars.search

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen() {
	val viewModel = koinViewModel<SearchViewModel>()
	Text(viewModel.string)
}