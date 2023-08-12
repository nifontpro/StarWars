package ru.nb.search_presenter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.RocketLaunch
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
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
import ru.nb.search_domain.model.Starship

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
	viewModel: SearchViewModel = hiltViewModel()
) {

	val favoritePeople by viewModel.favoritePeopleFlow.collectAsState(initial = emptyList())
	val favoriteStarship by viewModel.favoriteStarshipFlow.collectAsState(initial = emptyList())

	Column(
		modifier = Modifier.fillMaxSize()
	) {
		var searchText by remember { mutableStateOf("") }
		LaunchedEffect(key1 = searchText) {
			if (searchText.isBlank() || searchText.length < 2) return@LaunchedEffect
			delay(1000)
			viewModel.findPeople(searchText)
		}

		OutlinedTextField(
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth(),
			value = searchText,
			onValueChange = { searchText = it },
			placeholder = { Text("Search") },
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
		LazyColumn(
			verticalArrangement = Arrangement.spacedBy(8.dp)
		) {
			items(viewModel.baseUiList) { baseUi ->
				ElevatedCard(
					modifier = Modifier
						.padding(horizontal = 8.dp)
						.fillMaxWidth()
				) {
					Row(
						modifier = Modifier.padding(8.dp),
						verticalAlignment = Alignment.CenterVertically,
//						horizontalArrangement = Arrangement.SpaceBetween
					) {
						when (baseUi) {
							is People -> PeopleCard(
								people = baseUi,
								addToFavorite = viewModel::addPeopleToFavorite,
								removeFromFavorite = viewModel::removePeopleFromFavorite,
								checkInFavorite = { people -> people in favoritePeople }
							)

							is Starship -> StarshipCard(
								starship = baseUi,
								addToFavorite = viewModel::addStarshipToFavorite,
								removeFromFavorite = viewModel::removeStarshipFromFavorite,
								checkInFavorite = { starship -> starship in favoriteStarship }
								)
						}
					}
				}
			}
		}
	}
}

@Composable
private fun RowScope.PeopleCard(
	people: People,
	addToFavorite: (People) -> Unit,
	removeFromFavorite: (People) -> Unit,
	checkInFavorite: (People) -> Boolean
) {
	Icon(
		modifier = Modifier.padding(8.dp),
		imageVector = Icons.Outlined.Person,
		tint = MaterialTheme.colorScheme.primary,
		contentDescription = null
	)
	Column(modifier = Modifier.weight(1f)) {
		Text(text = people.name)
		Text(text = people.gender)
		Text(text = "Starships: ${people.starshipsCount}")
	}
	Icon(
		modifier = Modifier
			.padding(8.dp)
			.clickable(onClick = {
				if (checkInFavorite(people)) removeFromFavorite(people) else addToFavorite(people)
			}),
		imageVector = if (checkInFavorite(people)) Icons.Filled.Star else Icons.Outlined.StarBorder,
		tint = MaterialTheme.colorScheme.error,
		contentDescription = null
	)
}

@Composable
private fun RowScope.StarshipCard(
	starship: Starship,
	addToFavorite: (Starship) -> Unit,
	removeFromFavorite: (Starship) -> Unit,
	checkInFavorite: (Starship) -> Boolean
) {
	Icon(
		modifier = Modifier.padding(8.dp),
		imageVector = Icons.Outlined.RocketLaunch,
		tint = MaterialTheme.colorScheme.primary,
		contentDescription = null
	)
	Column(modifier = Modifier.weight(1f)) {
		Text(text = starship.name)
		Text(text = starship.model)
		Text(text = starship.passengers)
		Text(text = starship.manufacturer)
	}
	Icon(
		modifier = Modifier
			.padding(8.dp)
			.clickable(onClick = {
				if (checkInFavorite(starship)) removeFromFavorite(starship) else addToFavorite(starship)
			}),
		imageVector = if (checkInFavorite(starship)) Icons.Filled.Star else Icons.Outlined.StarBorder,
		tint = MaterialTheme.colorScheme.error,
		contentDescription = null
	)
}