package ru.nb.favorite_data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ru.nb.favorite_data.model.StarshipEntity

@Dao
interface StarshipDao : BaseDao<StarshipEntity> {

	@Transaction
	@Query("SELECT * FROM StarshipEntity")
	fun getAll(): Flow<List<StarshipEntity>>

	@Transaction
	@Query("SELECT url FROM StarshipEntity")
	fun getUrls(): Flow<List<String>>

}