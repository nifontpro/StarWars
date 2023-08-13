package ru.nb.favorite_presenter

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.RocketLaunch
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoriteScreen(
	paddingValues: PaddingValues,
	viewModel: FavoriteViewModel = hiltViewModel()
) {
	LazyColumn(
		modifier = Modifier.padding(paddingValues),
		verticalArrangement = Arrangement.spacedBy(8.dp)
	) {
		items(viewModel.favorites, key = { it.name }) { baseUi ->
			ElevatedCard(
				modifier = Modifier
					.padding(horizontal = 8.dp)
					.fillMaxWidth()
					.animateItemPlacement()
			) {
				Row(
					modifier = Modifier.padding(8.dp),
					verticalAlignment = Alignment.CenterVertically,
//						horizontalArrangement = Arrangement.SpaceBetween
				) {
					when (baseUi) {
						is People -> PeopleCard(
							people = baseUi,
							removeFromFavorite = viewModel::removePeopleFromFavorite,
						)

						is Starship -> StarshipCard(
							starship = baseUi,
							removeFromFavorite = viewModel::removeStarshipFromFavorite,
						)

						is Planet -> PlanetCard(
							planet = baseUi,
							removeFromFavorite = viewModel::removePlanetFromFavorite,
						)
					}
				}
			}
		}
	}
}

@Composable
private fun RowScope.PeopleCard(
	people: People,
	removeFromFavorite: (People) -> Unit,
) {
	Icon(
		modifier = Modifier.padding(8.dp),
		imageVector = Icons.Outlined.Person,
		tint = MaterialTheme.colorScheme.primary,
		contentDescription = null
	)
	Column(modifier = Modifier.weight(1f)) {
		Text(text = people.name, style = MaterialTheme.typography.titleMedium)
		Text(text = people.gender)
		Text(text = "Starships: ${people.starshipsCount}")
	}
	Icon(
		modifier = Modifier
			.padding(8.dp)
			.clickable(onClick = { removeFromFavorite(people) }),
		imageVector = Icons.Outlined.Delete,
		tint = MaterialTheme.colorScheme.error,
		contentDescription = null
	)
}

@Composable
private fun RowScope.StarshipCard(
	starship: Starship,
	removeFromFavorite: (Starship) -> Unit,
) {
	Icon(
		modifier = Modifier.padding(8.dp),
		imageVector = Icons.Outlined.RocketLaunch,
		tint = MaterialTheme.colorScheme.primary,
		contentDescription = null
	)
	Column(modifier = Modifier.weight(1f)) {
		Text(text = starship.name, style = MaterialTheme.typography.titleMedium)
		Text(text = starship.model)
		Text(text = "Passengers: ${starship.passengers}")
		Text(text = starship.manufacturer)
	}
	Icon(
		modifier = Modifier
			.padding(8.dp)
			.clickable(onClick = { removeFromFavorite(starship) }),
		imageVector = Icons.Outlined.Delete,
		tint = MaterialTheme.colorScheme.error,
		contentDescription = null
	)
}

@Composable
private fun RowScope.PlanetCard(
	planet: Planet,
	removeFromFavorite: (Planet) -> Unit,
) {
	Icon(
		modifier = Modifier.padding(8.dp),
		imageVector = Icons.Outlined.Public,
		tint = MaterialTheme.colorScheme.tertiary,
		contentDescription = null
	)
	Column(modifier = Modifier.weight(1f)) {
		Text(text = planet.name, style = MaterialTheme.typography.titleMedium)
		Text(text = "Diameter: " + planet.diameter)
		Text(text = "Population: " + planet.population)
	}
	Icon(
		modifier = Modifier
			.padding(8.dp)
			.clickable(onClick = { removeFromFavorite(planet) }),
		imageVector = Icons.Outlined.Delete,
		tint = MaterialTheme.colorScheme.error,
		contentDescription = null
	)
}