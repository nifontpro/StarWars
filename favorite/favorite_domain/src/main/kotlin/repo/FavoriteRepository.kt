package repo

import kotlinx.coroutines.flow.Flow
import model.People

interface FavoriteRepository {
	suspend fun add(people: People)
	suspend fun getAll(): Flow<List<People>>
}