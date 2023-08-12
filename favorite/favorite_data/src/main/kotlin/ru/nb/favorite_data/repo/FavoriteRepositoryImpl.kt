package ru.nb.favorite_data.repo

import ru.nb.favorite_data.db.dao.PeopleDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.nb.search_domain.model.People
import ru.nb.favorite_data.model.mappers.toPeople
import ru.nb.favorite_data.model.mappers.toPeopleEntity
import ru.nb.favorite_domain.repo.FavoriteRepository

class FavoriteRepositoryImpl(
	private val peopleDao: PeopleDao
) : FavoriteRepository {

	override suspend fun add(people: People) {
		peopleDao.insert(people.toPeopleEntity())
	}

	override fun getAll(): Flow<List<People>> {
		return peopleDao.getAll().map { list ->
			list.map { it.toPeople() }
		}
	}

}