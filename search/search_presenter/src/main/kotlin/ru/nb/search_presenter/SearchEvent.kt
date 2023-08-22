package ru.nb.search_presenter

import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship

sealed class SearchEvent {
	object ClearSearch : SearchEvent()
	data class OnSearch(val searchText: String) : SearchEvent()
	data class AddPeopleToFavorite(val people: People) : SearchEvent()
	data class RemovePeopleFromFavorite(val url: String) : SearchEvent()
	data class AddStarshipToFavorite(val starship: Starship) : SearchEvent()
	data class RemoveStarshipFromFavorite(val starship: Starship) : SearchEvent()
	data class AddPlanetToFavorite(val planet: Planet) : SearchEvent()
	data class RemovePlanetFromFavorite(val planet: Planet) : SearchEvent()
}
