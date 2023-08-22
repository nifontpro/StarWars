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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship
import ru.nb.starwars_compose.R

@Composable
fun SearchView(
	paddingValues: PaddingValues,
	state: SearchState,
	onEvent: (SearchEvent) -> Unit
) {
	Box(
		modifier = Modifier
			.padding(paddingValues)
			.fillMaxSize()
	) {

		Icon(
			imageVector = ImageVector.vectorResource(R.drawable.jedi),
			contentDescription = "",
			modifier = Modifier
				.align(Alignment.Center)
				.size(300.dp),
			tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
		)

		Column(
			modifier = Modifier
				.fillMaxWidth()
		) {

			OutlinedTextField(
				modifier = Modifier
					.padding(8.dp)
					.fillMaxWidth(),
				value = state.searchText,
				onValueChange = { onEvent(SearchEvent.OnSearch(it)) },
				placeholder = { Text(stringResource(R.string.search)) },
				leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
				trailingIcon = {
					Icon(
						modifier = Modifier.clickable { onEvent(SearchEvent.ClearSearch) },
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
					items(state.baseUiList, key = { it.url }) { baseUi ->
						ElevatedCard(
							modifier = Modifier
								.padding(horizontal = 8.dp)
								.fillMaxWidth()
								.alpha(0.95f)
						) {
							Row(
								modifier = Modifier.padding(8.dp),
								verticalAlignment = Alignment.CenterVertically,
							) {
								when (baseUi) {
									is People -> PeopleCard(
										people = baseUi,
										addToFavorite = { people -> onEvent(SearchEvent.AddPeopleToFavorite(people)) },
										removeFromFavorite = { url -> onEvent(SearchEvent.RemovePeopleFromFavorite(url)) },
										checkInFavorite = { url -> url in state.favoritePeoplesUrls }
									)

									is Starship -> StarshipCard(
										starship = baseUi,
										addToFavorite = { starship -> onEvent(SearchEvent.AddStarshipToFavorite(starship)) },
										removeFromFavorite = { starship ->
											onEvent(SearchEvent.RemoveStarshipFromFavorite(starship))
										},
										checkInFavorite = { url -> url in state.favoriteStarshipsUrls }
									)

									is Planet -> PlanetCard(
										planet = baseUi,
										addToFavorite = { planet -> onEvent(SearchEvent.AddPlanetToFavorite(planet)) },
										removeFromFavorite = { planet ->
											onEvent(SearchEvent.RemovePlanetFromFavorite(planet))
										},
										checkInFavorite = { url -> url in state.favoritePlanetsUrls }
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
						text = stringResource(id = R.string.loading_data_error),
						color = MaterialTheme.colorScheme.error,
						modifier = Modifier.align(Alignment.Center)
					)
				}
			}
		}
	}
}