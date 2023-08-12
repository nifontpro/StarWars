package db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import model.PeopleEntity

@Dao
interface PeopleDao : BaseDao<PeopleEntity> {

	@Transaction
	@Query("SELECT * FROM PeopleEntity")
	suspend fun getAll(): Flow<List<PeopleEntity>>

}