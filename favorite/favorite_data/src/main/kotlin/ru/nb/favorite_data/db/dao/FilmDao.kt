package ru.nb.favorite_data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import ru.nb.favorite_data.model.FilmEntity

@Dao
interface FilmDao : BaseDao<FilmEntity> {

	@Transaction
	@Query("SELECT * FROM FilmEntity WHERE filmUrl=:url")
	suspend fun getByUrl(url: String): FilmEntity?

}