package ru.nb.search_presenter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import ru.nb.favorite_domain.repo.FavoriteRepository
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

	var state by mutableStateOf(SearchState())
		private set

	private val favoritePeoplesUrlsFlow = favoriteRepository.getPeoplesUrls()
	private val favoriteStarshipsUrlsFlow = favoriteRepository.getStarshipsUrls()
	private val favoritePlanetUrlsFlow = favoriteRepository.getPlanetsUrls()

	init {
		viewModelScope.launch {
			launch {
				favoritePeoplesUrlsFlow.collectLatest {
					state = state.copy(favoritePeoplesUrls = it)
				}
			}
			launch {
				favoriteStarshipsUrlsFlow.collectLatest {
					state = state.copy(favoriteStarshipsUrls = it)
				}
			}
			launch {
				favoritePlanetUrlsFlow.collectLatest {
					state = state.copy(favoritePlanetsUrls = it)
				}
			}
		}
	}

	fun onEvent(event: SearchEvent) {
		when (event) {
			SearchEvent.ClearSearch -> state = state.copy(searchText = "")
			is SearchEvent.OnSearch -> search(searchText = event.searchText)
			is SearchEvent.AddPeopleToFavorite -> addPeopleToFavorite(people = event.people)
			is SearchEvent.AddPlanetToFavorite -> addPlanetToFavorite(planet = event.planet)
			is SearchEvent.AddStarshipToFavorite -> addStarshipToFavorite(starship = event.starship)
			is SearchEvent.RemovePeopleFromFavorite -> removePeopleFromFavorite(url = event.url)
			is SearchEvent.RemovePlanetFromFavorite -> removePlanetFromFavorite(planet = event.planet)
			is SearchEvent.RemoveStarshipFromFavorite -> removeStarshipFromFavorite(starship = event.starship)
		}
	}

	private var job: Job? = null
	private fun search(searchText: String) {
		state = state.copy(searchText = searchText)
		if (searchText.isBlank() || searchText.length < 2) return
		job?.cancel()
		job = viewModelScope.launch {
			delay(500L)
			supervisorScope {
				state = state.copy(isLoading = true)

				val peoplesDef = async {
					peopleRepository.search(searchText = searchText)
				}

				val starshipsDef = async {
					starshipRepository.search(searchText = searchText)
				}

				val planetsDef = async {
					planetRepository.search(searchText = searchText)
				}

				state = try {
					val peoples = peoplesDef.await().data
					val starships = starshipsDef.await().data
					val planets = planetsDef.await().data
					state.copy(
						baseUiList = (peoples + starships + planets).sortedBy { it.name },
						isLoading = false,
						isError = false,
					)
				} catch (e: CancellationException) {
					println("Search: CancellationException")
					state.copy(
						isLoading = false,
						isError = false,
					)
				} catch (e: Exception) {
					state.copy(isError = true, isLoading = false)
				}
			}
		}
	}

	private fun addPeopleToFavorite(people: People) {
		viewModelScope.launch {

			favoriteRepository.addPeople(people)

			people.filmsUrls.map { filmUrl ->
				launch {
					favoriteRepository.addFilm(peopleUrl = people.url, filmUrl = filmUrl)
				}
			}
		}
	}

	private fun removePeopleFromFavorite(url: String) {
		viewModelScope.launch {
			favoriteRepository.removePeople(url)
		}
	}

	private fun addStarshipToFavorite(starship: Starship) {
		viewModelScope.launch {
			favoriteRepository.addStarship(starship)
		}
	}

	private fun removeStarshipFromFavorite(starship: Starship) {
		viewModelScope.launch {
			favoriteRepository.removeStarship(starship)
		}
	}

	private fun addPlanetToFavorite(planet: Planet) {
		viewModelScope.launch {
			favoriteRepository.addPlanet(planet)
		}
	}

	private fun removePlanetFromFavorite(planet: Planet) {
		viewModelScope.launch {
			favoriteRepository.removePlanet(planet)
		}
	}

}
