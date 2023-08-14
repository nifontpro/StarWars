package ru.nb.favorite_data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ru.nb.favorite_data.model.PeopleEntity

@Dao
interface PeopleDao : BaseDao<PeopleEntity> {

	@Transaction
	@Query("SELECT * FROM PeopleEntity")
	fun getAll(): Flow<List<PeopleEntity>>

	@Transaction
	@Query("SELECT url FROM PeopleEntity")
	fun getUrls(): Flow<List<String>>

}