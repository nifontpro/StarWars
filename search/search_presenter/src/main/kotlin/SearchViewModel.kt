import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import model.People
import repo.PeopleRepository

class SearchViewModel(
	val string: String,
	private val peopleRepository: PeopleRepository
) : ViewModel() {

	var peoples by mutableStateOf<List<People>>(emptyList())

	init {
		viewModelScope.launch {
			val result = peopleRepository.getPeople()
			peoples = result.data
		}
	}

}
