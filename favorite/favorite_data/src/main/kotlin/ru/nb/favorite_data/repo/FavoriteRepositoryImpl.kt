package ru.nb.favorite_data.repo

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.nb.favorite_data.db.dao.FilmDao
import ru.nb.favorite_data.db.dao.PeopleDao
import ru.nb.favorite_data.db.dao.PeopleWithFilmDao
import ru.nb.favorite_data.db.dao.PlanetDao
import ru.nb.favorite_data.db.dao.StarshipDao
import ru.nb.favorite_data.model.FilmDto
import ru.nb.favorite_data.model.PeopleFilmCrossRef
import ru.nb.favorite_data.model.mappers.toFilm
import ru.nb.favorite_data.model.mappers.toFilmEntity
import ru.nb.favorite_data.model.mappers.toPeople
import ru.nb.favorite_data.model.mappers.toPeopleEntity
import ru.nb.favorite_data.model.mappers.toPeopleWithFilms
import ru.nb.favorite_data.model.mappers.toPlanet
import ru.nb.favorite_data.model.mappers.toPlanetEntity
import ru.nb.favorite_data.model.mappers.toStarship
import ru.nb.favorite_data.model.mappers.toStarshipEntity
import ru.nb.favorite_domain.model.PeopleWithFilms
import ru.nb.favorite_domain.repo.FavoriteRepository
import ru.nb.search_domain.model.People
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.model.Starship

class FavoriteRepositoryImpl(
	private val httpClient: HttpClient,
	private val peopleDao: PeopleDao,
	private val starshipDao: StarshipDao,
	private val planetDao: PlanetDao,
	private val filmDao: FilmDao,
	private val peopleWithFilmDao: PeopleWithFilmDao,
) : FavoriteRepository {

	override suspend fun addPeople(people: People) {
		peopleDao.insert(people.toPeopleEntity())
	}

	override suspend fun removePeople(url: String) {
			peopleDao.deleteByUrl(url)
	}

	override fun getAllPeoples(): Flow<List<People>> {
		return peopleDao.getAll().map { list ->
			list.map { it.toPeople() }
		}
	}

	override fun getPeoplesWithFilms(): Flow<List<PeopleWithFilms>> {
		return peopleDao.getPeopleWithFilms().map { list ->
			list.map { it.toPeopleWithFilms() }
		}
	}

	override fun getPeoplesUrls(): Flow<List<String>> {
		return peopleDao.getUrls()
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

	override fun getStarshipsUrls(): Flow<List<String>> {
		return starshipDao.getUrls()
	}

	override suspend fun addPlanet(planet: Planet) {
			planetDao.insert(planet.toPlanetEntity())
	}

	override suspend fun removePlanet(planet: Planet) {
			planetDao.delete(planet.toPlanetEntity())
	}

	override fun getAllPlanets(): Flow<List<Planet>> {
		return planetDao.getAll().map { list ->
			list.map { it.toPlanet() }
		}
	}

	override fun getPlanetsUrls(): Flow<List<String>> {
		return planetDao.getUrls()
	}

	override suspend fun addFilm(peopleUrl: String, filmUrl: String) {
		withContext(Dispatchers.IO) {
			// Получаем фильм из API или из кэша БД
			try {
				val filmEntity = filmDao.getByUrl(url = filmUrl)
				val film = if (filmEntity != null) {
					Log.i("Film", "Film <${filmEntity.title}> get from cache db")
					filmEntity.toFilm()
				} else {
					val filmDto: FilmDto = httpClient.get(filmUrl) {
					}.body()
					filmDto.toFilm()
				}
				filmDao.insert(film.toFilmEntity()) // Сохраняем фильм в кэш
				peopleWithFilmDao.insert(PeopleFilmCrossRef(peopleUrl = peopleUrl, filmUrl = filmUrl))
			} catch (e: Exception) {
				Log.e("Film", "Error get film <$filmUrl> and save to favorite")
			}
		}
	}

}