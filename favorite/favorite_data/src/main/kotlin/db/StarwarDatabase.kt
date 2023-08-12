package db

import androidx.room.Database
import androidx.room.RoomDatabase
import db.dao.PeopleDao
import model.PeopleEntity

@Database(
	entities = [PeopleEntity::class],
	version = 1,
	exportSchema = false
)
abstract class StarwarDatabase : RoomDatabase() {
	abstract val peopleDao: PeopleDao
}