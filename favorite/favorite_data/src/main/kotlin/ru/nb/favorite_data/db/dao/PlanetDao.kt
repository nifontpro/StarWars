package ru.nb.favorite_data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ru.nb.favorite_data.model.PlanetEntity

@Dao
interface PlanetDao : BaseDao<PlanetEntity> {

	@Transaction
	@Query("SELECT * FROM PlanetEntity")
	fun getAll(): Flow<List<PlanetEntity>>

}