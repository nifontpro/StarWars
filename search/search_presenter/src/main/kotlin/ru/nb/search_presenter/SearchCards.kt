package ru.nb.search_presenter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.RocketLaunch
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship
import ru.nb.starwars_compose.R

@Composable
fun RowScope.PeopleCard(
	people: People,
	addToFavorite: (People) -> Unit,
	removeFromFavorite: (String) -> Unit,
	checkInFavorite: (String) -> Boolean
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
		Text(text = stringResource(R.string.starships) + people.starshipsCount)
	}
	Icon(
		modifier = Modifier
			.padding(8.dp)
			.clickable(onClick = {
				if (checkInFavorite(people.url)) removeFromFavorite(people.url) else addToFavorite(people)
			}),
		imageVector = if (checkInFavorite(people.url)) Icons.Filled.Star else Icons.Outlined.StarBorder,
		tint = MaterialTheme.colorScheme.error,
		contentDescription = null
	)
}

@Composable
fun RowScope.StarshipCard(
	starship: Starship,
	addToFavorite: (Starship) -> Unit,
	removeFromFavorite: (Starship) -> Unit,
	checkInFavorite: (String) -> Boolean
) {
	Icon(
		modifier = Modifier.padding(8.dp),
		imageVector = Icons.Outlined.RocketLaunch,
		tint = MaterialTheme.colorScheme.secondary,
		contentDescription = null
	)
	Column(modifier = Modifier.weight(1f)) {
		Text(text = starship.name, style = MaterialTheme.typography.titleMedium)
		Text(text = starship.model)
		Text(text = stringResource(R.string.passengers) + starship.passengers)
		Text(text = starship.manufacturer)
	}
	Icon(
		modifier = Modifier
			.padding(8.dp)
			.clickable(onClick = {
				if (checkInFavorite(starship.url)) removeFromFavorite(starship) else addToFavorite(starship)
			}),
		imageVector = if (checkInFavorite(starship.url)) Icons.Filled.Star else Icons.Outlined.StarBorder,
		tint = MaterialTheme.colorScheme.error,
		contentDescription = null
	)
}

@Composable
fun RowScope.PlanetCard(
	planet: Planet,
	addToFavorite: (Planet) -> Unit,
	removeFromFavorite: (Planet) -> Unit,
	checkInFavorite: (String) -> Boolean
) {
	Icon(
		modifier = Modifier.padding(8.dp),
		imageVector = Icons.Outlined.Public,
		tint = MaterialTheme.colorScheme.tertiary,
		contentDescription = null
	)
	Column(modifier = Modifier.weight(1f)) {
		Text(text = planet.name, style = MaterialTheme.typography.titleMedium)
		Text(text = stringResource(R.string.diameter) + planet.diameter)
		Text(text = stringResource(R.string.population) + planet.population)
	}
	Icon(
		modifier = Modifier
			.padding(8.dp)
			.clickable(onClick = {
				if (checkInFavorite(planet.url)) removeFromFavorite(planet) else addToFavorite(planet)
			}),
		imageVector = if (checkInFavorite(planet.url)) Icons.Filled.Star else Icons.Outlined.StarBorder,
		tint = MaterialTheme.colorScheme.error,
		contentDescription = null
	)
}