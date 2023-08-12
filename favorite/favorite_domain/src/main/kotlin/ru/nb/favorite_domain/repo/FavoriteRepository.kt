package ru.nb.favorite_domain.repo

import kotlinx.coroutines.flow.Flow
import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Starship

interface FavoriteRepository {
	suspend fun addPeople(people: People)
	fun getAllPeoples(): Flow<List<People>>
	suspend fun removePeople(people: People)
	suspend fun addStarship(starship: Starship)
	suspend fun removeStarship(starship: Starship)
	fun getAllStarships(): Flow<List<Starship>>
}