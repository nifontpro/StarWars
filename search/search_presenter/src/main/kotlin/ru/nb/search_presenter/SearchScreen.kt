package ru.nb.search_presenter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay
import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship

@Composable
fun SearchScreen(
	paddingValues: PaddingValues,
	viewModel: SearchViewModel = hiltViewModel()
) {

	val state = viewModel.state

	val favoritePeoples by viewModel.favoritePeopleFlow.collectAsState(initial = emptyList())
	val favoriteStarships by viewModel.favoriteStarshipFlow.collectAsState(initial = emptyList())
	val favoritePlanets by viewModel.favoritePlanetFlow.collectAsState(initial = emptyList())

	Column(
		modifier = Modifier
			.padding(paddingValues)
			.fillMaxSize()
	) {

		var searchText by remember { mutableStateOf("") }
		LaunchedEffect(key1 = searchText) {
			if (searchText.isBlank() || searchText.length < 2) return@LaunchedEffect
			delay(500)
			viewModel.search(searchText)
		}

		OutlinedTextField(
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth(),
			value = searchText,
			onValueChange = { searchText = it },
//			placeholder = { Text(stringResource(androidx.compose.material3.R.string.search_bar_search)) },
			leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
			trailingIcon = {
				Icon(
					modifier = Modifier.clickable { searchText = "" },
					imageVector = Icons.Default.Close,
					contentDescription = "Cancel"
				)
			},
			singleLine = true
		)
		Box(modifier = Modifier.fillMaxSize()) {

			LazyColumn(
				verticalArrangement = Arrangement.spacedBy(8.dp)
			) {
				items(state.baseUiList, key = { it.name }) { baseUi ->
					ElevatedCard(
						modifier = Modifier
							.padding(horizontal = 8.dp)
							.fillMaxWidth()
					) {
						Row(
							modifier = Modifier.padding(8.dp),
							verticalAlignment = Alignment.CenterVertically,
						) {
							when (baseUi) {
								is People -> PeopleCard(
									people = baseUi,
									addToFavorite = viewModel::addPeopleToFavorite,
									removeFromFavorite = viewModel::removePeopleFromFavorite,
									checkInFavorite = { people -> people in favoritePeoples }
								)

								is Starship -> StarshipCard(
									starship = baseUi,
									addToFavorite = viewModel::addStarshipToFavorite,
									removeFromFavorite = viewModel::removeStarshipFromFavorite,
									checkInFavorite = { starship -> starship in favoriteStarships }
								)

								is Planet -> PlanetCard(
									planet = baseUi,
									addToFavorite = viewModel::addPlanetToFavorite,
									removeFromFavorite = viewModel::removePlanetFromFavorite,
									checkInFavorite = { planet -> planet in favoritePlanets }
								)
							}
						}
					}
				}
			}

			if (state.isLoading) {
				CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
			}

			if (state.isError) {
				Text(
					text = "Load data error",
					color = MaterialTheme.colorScheme.error,
					modifier = Modifier.align(Alignment.Center)
				)
			}
		}
	}
}