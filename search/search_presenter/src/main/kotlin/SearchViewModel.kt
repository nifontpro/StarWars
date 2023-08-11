import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import model.BaseUi
import repo.PeopleRepository
import repo.StarshipRepository

class SearchViewModel(
	private val peopleRepository: PeopleRepository,
	private val starshipRepository: StarshipRepository,
) : ViewModel() {

	var baseUiList by mutableStateOf<List<BaseUi>>(emptyList())

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

}
