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
import ru.nb.search_domain.model.Starship
import ru.nb.search_domain.repo.PeopleRepository
import ru.nb.search_domain.repo.StarshipRepository
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
	private val peopleRepository: PeopleRepository,
	private val starshipRepository: StarshipRepository,
	private val favoriteRepository: FavoriteRepository,
) : ViewModel() {

	var baseUiList by mutableStateOf<List<BaseUi>>(emptyList())

//	var favorites by mutableStateOf<List<BaseUi>>(emptyList())

	val favoritePeopleFlow = favoriteRepository.getAllPeoples()
	val favoriteStarshipFlow = favoriteRepository.getAllStarships()

	/*	private var favoritePeople by mutableStateOf<List<People>>(emptyList())
		private var favoriteStarship by mutableStateOf<List<People>>(emptyList())

		init {
			viewModelScope.launch {
				favoritePeopleFlow.collectLatest {
					favoritePeople = it
					favorites = it
				}
			}
		}*/

	fun findPeople(search: String) {
		viewModelScope.launch {
			val peoplesDef = async {
				peopleRepository.search(searchText = search)
			}
			val starshipsDef = async {
				starshipRepository.search(searchText = search)
			}

			val peoples = peoplesDef.await().data
			val starships = starshipsDef.await().data

			baseUiList = (peoples + starships).sortedBy { it.name }

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

}
