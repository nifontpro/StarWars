package ru.nb.starwars.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nb.starwars.data.repo.PeopleRepositoryImpl

class SearchViewModel(
	val string: String,
	private val peopleRepository: PeopleRepositoryImpl
) : ViewModel() {

	init {
		viewModelScope.launch {
			val result = peopleRepository.getPeople()
			println(result)
		}
	}

}
