package ru.nb.search_presenter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.nb.favorite_domain.repo.FavoriteRepository
import ru.nb.search_domain.model.BaseUi
import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship
import ru.nb.search_domain.repo.PeopleRepository
import ru.nb.search_domain.repo.PlanetRepository
import ru.nb.search_domain.repo.StarshipRepository
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
	private val peopleRepository: PeopleRepository,
	private val starshipRepository: StarshipRepository,
	private val planetRepository: PlanetRepository,
	private val favoriteRepository: FavoriteRepository,
) : ViewModel() {

	var baseUiList by mutableStateOf<List<BaseUi>>(emptyList())

	val favoritePeopleFlow = favoriteRepository.getAllPeoples()
	val favoriteStarshipFlow = favoriteRepository.getAllStarships()
	val favoritePlanetFlow = favoriteRepository.getAllPlanets()

	fun findBaseUiList(searchText: String) {
		viewModelScope.launch {
			val peoplesDef = async {
				peopleRepository.search(searchText = searchText)
			}
			val starshipsDef = async {
				starshipRepository.search(searchText = searchText)
			}

			val planetsDef = async {
				planetRepository.search(searchText = searchText)
			}

			val peoples = peoplesDef.await().data
			val starships = starshipsDef.await().data
			val planets = planetsDef.await().data

			baseUiList = (peoples + starships + planets).sortedBy { it.name }

		}
	}

	fun addPeopleToFavorite(people: People) {
		viewModelScope.launch {
			favoriteRepository.addPeople(people)
		}
	}

	fun removePeopleFromFavorite(people: People) {
		viewModelScope.launch {
			favoriteRepository.removePeople(people)
		}
	}

	fun addStarshipToFavorite(starship: Starship) {
		viewModelScope.launch {
			favoriteRepository.addStarship(starship)
		}
	}

	fun removeStarshipFromFavorite(starship: Starship) {
		viewModelScope.launch {
			favoriteRepository.removeStarship(starship)
		}
	}

	fun addPlanetToFavorite(planet: Planet) {
		viewModelScope.launch {
			favoriteRepository.addPlanet(planet)
		}
	}

	fun removePlanetFromFavorite(planet: Planet) {
		viewModelScope.launch {
			favoriteRepository.removePlanet(planet)
		}
	}

}
