package repo

import db.dao.PeopleDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.People
import model.mappers.toPeople
import model.mappers.toPeopleEntity

class FavoriteRepositoryImpl(
	private val peopleDao: PeopleDao
) : FavoriteRepository {

	override suspend fun add(people: People) {
		peopleDao.insert(people.toPeopleEntity())
	}

	override suspend fun getAll(): Flow<List<People>> {
		return peopleDao.getAll().map { list ->
			list.map { it.toPeople() }
		}
	}

}