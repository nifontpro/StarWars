package ru.nb.favorite_presenter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.RocketLaunch
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import ru.nb.favorite_domain.model.PeopleWithFilms
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship
import ru.nb.starwars_compose.R

@Composable
fun PeopleCard(
	people: PeopleWithFilms,
	removeFromFavorite: (String) -> Unit,
) {
	var expanded by rememberSaveable { mutableStateOf(false) }
	Row(
		modifier = Modifier.padding(8.dp),
		verticalAlignment = Alignment.CenterVertically,
	) {
		Icon(
			modifier = Modifier
				.padding(8.dp)
				.clickable { expanded = !expanded },
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
				.clickable(onClick = { removeFromFavorite(people.url) }),
			imageVector = Icons.Outlined.Delete,
			tint = MaterialTheme.colorScheme.error,
			contentDescription = null
		)
	}
	if (expanded) {
		Column(modifier = Modifier.padding(start = 50.dp)) {
			Text(
				stringResource(R.string.films),
				style = MaterialTheme.typography.titleMedium.copy(fontStyle = FontStyle.Italic)
			)
			people.films.forEach { film ->
				Spacer(modifier = Modifier.height(8.dp))
				Text(film.title, style = MaterialTheme.typography.titleMedium)
				Text(stringResource(R.string.director) + film.director)
				Text(stringResource(R.string.producer) + film.producer)
			}
		}
	}
}

@Composable
fun StarshipCard(
	starship: Starship,
	removeFromFavorite: (Starship) -> Unit,
) {
	Row(
		modifier = Modifier.padding(8.dp),
		verticalAlignment = Alignment.CenterVertically,
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
			Text(text = stringResource(R.string.passengers) + starship.passengers)
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
}

@Composable
fun PlanetCard(
	planet: Planet,
	removeFromFavorite: (Planet) -> Unit,
) {
	Row(
		modifier = Modifier.padding(8.dp),
		verticalAlignment = Alignment.CenterVertically,
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
				.clickable(onClick = { removeFromFavorite(planet) }),
			imageVector = Icons.Outlined.Delete,
			tint = MaterialTheme.colorScheme.error,
			contentDescription = null
		)
	}
}