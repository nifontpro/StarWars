package ru.nb.favorite_presenter

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.nb.favorite_domain.model.PeopleWithFilms
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship
import ru.nb.starwars_compose.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoriteScreen(
	paddingValues: PaddingValues,
	viewModel: FavoriteViewModel = hiltViewModel()
) {
	Box(
		modifier = Modifier
			.padding(paddingValues)
			.fillMaxSize()
	) {

		Icon(
			imageVector = ImageVector.vectorResource(R.drawable.favorite),
			contentDescription = "",
			modifier = Modifier
				.align(Alignment.Center)
				.size(300.dp),
			tint = MaterialTheme.colorScheme.secondary.copy(alpha = 0.8f)
		)
		LazyColumn(
			verticalArrangement = Arrangement.spacedBy(8.dp)
		) {
			items(viewModel.favorites, key = { it.name }) { baseUi ->
				ElevatedCard(
					modifier = Modifier
						.padding(horizontal = 8.dp)
						.fillMaxWidth()
						.alpha(0.95f)
						.animateItemPlacement()
						.animateContentSize()
				) {

					when (baseUi) {
						is PeopleWithFilms -> PeopleCard(
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