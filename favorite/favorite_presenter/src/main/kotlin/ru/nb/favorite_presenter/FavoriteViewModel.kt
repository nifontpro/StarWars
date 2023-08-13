package ru.nb.favorite_presenter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import ru.nb.favorite_domain.repo.FavoriteRepository
import ru.nb.search_domain.model.BaseUi
import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
	private val favoriteRepository: FavoriteRepository,
) : ViewModel() {

	private val favoritePeopleFlow = favoriteRepository.getAllPeoples()
	private val favoriteStarshipFlow = favoriteRepository.getAllStarships()
	private val favoritePlanetFlow = favoriteRepository.getAllPlanets()

	private val favoritePeopleState = MutableStateFlow<List<People>>(emptyList())
	private val favoriteStarshipState = MutableStateFlow<List<Starship>>(emptyList())
	private val favoritePlanetState = MutableStateFlow<List<Planet>>(emptyList())

	var favorites by mutableStateOf<List<BaseUi>>(emptyList())

	init {
		viewModelScope.launch {
			launch {
				favoritePeopleFlow.collectLatest {
					favoritePeopleState.value = it
				}
			}

			launch {
				favoriteStarshipFlow.collectLatest {
					favoriteStarshipState.value = it
				}
			}

			launch {
				favoritePlanetFlow.collectLatest {
					favoritePlanetState.value = it
				}
			}

			launch {
				favoritePeopleState.combine(favoriteStarshipState) { peoples, starships ->
					peoples + starships
				}.combine(favoritePlanetState) { peoplesAndStarships, planets ->
					favorites = (peoplesAndStarships + planets).sortedBy { it.name }
				}.collect()
			}
		}
	}

	fun removePeopleFromFavorite(people: People) {
		viewModelScope.launch {
			favoriteRepository.removePeople(people)
		}
	}

	fun removeStarshipFromFavorite(starship: Starship) {
		viewModelScope.launch {
			favoriteRepository.removeStarship(starship)
		}
	}

	fun removePlanetFromFavorite(planet: Planet) {
		viewModelScope.launch {
			favoriteRepository.removePlanet(planet)
		}
	}
}