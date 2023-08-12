package ru.nb.favorite_data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.nb.favorite_data.db.dao.PeopleDao
import ru.nb.favorite_data.db.dao.StarshipDao
import ru.nb.favorite_data.model.PeopleEntity
import ru.nb.favorite_data.model.StarshipEntity

@Database(
	entities = [PeopleEntity::class, StarshipEntity::class],
	version = 2,
	exportSchema = false
)
abstract class StarwarDatabase : RoomDatabase() {
	abstract val peopleDao: PeopleDao
	abstract val starshipDao: StarshipDao
}