package ru.nb.favorite_data.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.nb.favorite_data.db.dao.PeopleDao
import ru.nb.favorite_data.db.dao.PlanetDao
import ru.nb.favorite_data.db.dao.StarshipDao
import ru.nb.favorite_data.model.mappers.toPeople
import ru.nb.favorite_data.model.mappers.toPeopleEntity
import ru.nb.favorite_data.model.mappers.toPlanet
import ru.nb.favorite_data.model.mappers.toPlanetEntity
import ru.nb.favorite_data.model.mappers.toStarship
import ru.nb.favorite_data.model.mappers.toStarshipEntity
import ru.nb.favorite_domain.repo.FavoriteRepository
import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship

class FavoriteRepositoryImpl(
	private val peopleDao: PeopleDao,
	private val starshipDao: StarshipDao,
	private val planetDao: PlanetDao
) : FavoriteRepository {

	override suspend fun addPeople(people: People) {
		withContext(Dispatchers.IO) {
			peopleDao.insert(people.toPeopleEntity())
		}
	}

	override suspend fun removePeople(people: People) {
		withContext(Dispatchers.IO) {
			peopleDao.delete(people.toPeopleEntity())
		}
	}

	override fun getAllPeoples(): Flow<List<People>> {
		return peopleDao.getAll().map { list ->
			list.map { it.toPeople() }
		}
	}

	override suspend fun addStarship(starship: Starship) {
		withContext(Dispatchers.IO) {
			starshipDao.insert(starship.toStarshipEntity())
		}
	}

	override suspend fun removeStarship(starship: Starship) {
		withContext(Dispatchers.IO) {
			starshipDao.delete(starship.toStarshipEntity())
		}
	}

	override fun getAllStarships(): Flow<List<Starship>> {
		return starshipDao.getAll().map { list ->
			list.map { it.toStarship() }
		}
	}

	override suspend fun addPlanet(planet: Planet) {
		withContext(Dispatchers.IO) {
			planetDao.insert(planet.toPlanetEntity())
		}
	}

	override suspend fun removePlanet(planet: Planet) {
		withContext(Dispatchers.IO) {
			planetDao.delete(planet.toPlanetEntity())
		}
	}

	override fun getAllPlanets(): Flow<List<Planet>> {
		return planetDao.getAll().map { list ->
			list.map { it.toPlanet() }
		}
	}

}