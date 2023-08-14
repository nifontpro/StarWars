package ru.nb.favorite_data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.nb.favorite_data.db.dao.FilmDao
import ru.nb.favorite_data.db.dao.PeopleDao
import ru.nb.favorite_data.db.dao.PeopleWithFilmDao
import ru.nb.favorite_data.db.dao.PlanetDao
import ru.nb.favorite_data.db.dao.StarshipDao
import ru.nb.favorite_data.model.FilmEntity
import ru.nb.favorite_data.model.PeopleEntity
import ru.nb.favorite_data.model.PeopleFilmCrossRef
import ru.nb.favorite_data.model.PlanetEntity
import ru.nb.favorite_data.model.StarshipEntity

@Database(
	entities = [
		PeopleEntity::class,
		StarshipEntity::class,
		PlanetEntity::class,
		FilmEntity::class,
		PeopleFilmCrossRef::class
	],
	version = 4,
	exportSchema = false
)
abstract class StarwarDatabase : RoomDatabase() {
	abstract val peopleDao: PeopleDao
	abstract val starshipDao: StarshipDao
	abstract val planetDao: PlanetDao
	abstract val filmDao: FilmDao
	abstract val peopleWithFilmDao: PeopleWithFilmDao
}