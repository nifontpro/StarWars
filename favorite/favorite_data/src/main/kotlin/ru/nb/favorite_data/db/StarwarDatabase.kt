package ru.nb.favorite_data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.nb.favorite_data.db.dao.PeopleDao
import ru.nb.favorite_data.model.PeopleEntity

@Database(
	entities = [PeopleEntity::class],
	version = 1,
	exportSchema = false
)
abstract class StarwarDatabase : RoomDatabase() {
	abstract val peopleDao: PeopleDao
}