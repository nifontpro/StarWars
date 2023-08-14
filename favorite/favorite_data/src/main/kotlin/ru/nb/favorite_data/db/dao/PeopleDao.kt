package ru.nb.favorite_data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ru.nb.favorite_data.model.PeopleEntity
import ru.nb.favorite_data.model.PeopleWithFilmsEntity

@Dao
interface PeopleDao : BaseDao<PeopleEntity> {

	@Transaction
	@Query("SELECT * FROM PeopleEntity")
	fun getAll(): Flow<List<PeopleEntity>>

	@Transaction
	@Query("SELECT peopleUrl FROM PeopleEntity")
	fun getUrls(): Flow<List<String>>

	@Transaction
	@Query("SELECT * FROM PeopleEntity")
	fun getPeopleWithFilms(): Flow<List<PeopleWithFilmsEntity>>

	@Query("DELETE FROM PeopleEntity WHERE peopleUrl=:url")
	suspend fun deleteByUrl(url: String)

}