import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import model.BaseUi
import model.People
import repo.FavoriteRepository
import repo.PeopleRepository
import repo.StarshipRepository

class SearchViewModel(
	private val peopleRepository: PeopleRepository,
	private val starshipRepository: StarshipRepository,
	private val favoriteRepository: FavoriteRepository,
) : ViewModel() {

	var baseUiList by mutableStateOf<List<BaseUi>>(emptyList())

	var favorites by mutableStateOf<List<BaseUi>>(emptyList())


	init {
		viewModelScope.launch {
			val favoritePeople = favoriteRepository.getAll()
			merge(favoritePeople).onEach {
				favorites = it
				println(it)
			}
		}

	}

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

	fun addToFavorite(people: People) {
		viewModelScope.launch {
			favoriteRepository.add(people)
		}
	}

}
