package ru.nb.favorite_data.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.nb.favorite_data.db.dao.PeopleDao
import ru.nb.favorite_data.db.dao.StarshipDao
import ru.nb.favorite_data.model.mappers.toPeople
import ru.nb.favorite_data.model.mappers.toPeopleEntity
import ru.nb.favorite_data.model.mappers.toStarship
import ru.nb.favorite_data.model.mappers.toStarshipEntity
import ru.nb.favorite_domain.repo.FavoriteRepository
import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Starship

class FavoriteRepositoryImpl(
	private val peopleDao: PeopleDao,
	private val starshipDao: StarshipDao
) : FavoriteRepository {

	override suspend fun addPeople(people: People) {
		peopleDao.insert(people.toPeopleEntity())
	}

	override suspend fun removePeople(people: People) {
		peopleDao.delete(people.toPeopleEntity())
	}

	override fun getAllPeoples(): Flow<List<People>> {
		return peopleDao.getAll().map { list ->
			list.map { it.toPeople() }
		}
	}

	override suspend fun addStarship(starship: Starship) {
		starshipDao.insert(starship.toStarshipEntity())
	}

	override suspend fun removeStarship(starship: Starship) {
		starshipDao.delete(starship.toStarshipEntity())
	}

	override fun getAllStarships(): Flow<List<Starship>> {
		return starshipDao.getAll().map { list ->
			list.map { it.toStarship() }
		}
	}

}