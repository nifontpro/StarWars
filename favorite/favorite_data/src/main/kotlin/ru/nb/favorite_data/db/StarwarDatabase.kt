package ru.nb.favorite_data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.nb.favorite_data.db.dao.PeopleDao
import ru.nb.favorite_data.db.dao.PlanetDao
import ru.nb.favorite_data.db.dao.StarshipDao
import ru.nb.favorite_data.model.PeopleEntity
import ru.nb.favorite_data.model.PlanetEntity
import ru.nb.favorite_data.model.StarshipEntity

@Database(
	entities = [PeopleEntity::class, StarshipEntity::class, PlanetEntity::class],
	version = 3,
	exportSchema = false
)
abstract class StarwarDatabase : RoomDatabase() {
	abstract val peopleDao: PeopleDao
	abstract val starshipDao: StarshipDao
	abstract val planetDao: PlanetDao
}