package ru.nb.favorite_data.db.dao

import androidx.room.Dao
import ru.nb.favorite_data.model.PeopleFilmCrossRef

@Dao
interface PeopleWithFilmDao : BaseDao<PeopleFilmCrossRef>