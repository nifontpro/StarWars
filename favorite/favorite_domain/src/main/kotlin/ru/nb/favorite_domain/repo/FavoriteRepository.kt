package ru.nb.favorite_domain.repo

import kotlinx.coroutines.flow.Flow
import ru.nb.search_domain.model.People

interface FavoriteRepository {
	suspend fun add(people: People)
	fun getAll(): Flow<List<People>>
}