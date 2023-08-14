package ru.nb.favorite_data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class PeopleWithFilmsEntity(

	@Embedded
	val peopleEntity: PeopleEntity,

	@Relation(
		parentColumn = "peopleUrl",
		entityColumn = "filmUrl",
		associateBy = Junction(PeopleFilmCrossRef::class)
	)
	val films: List<FilmEntity>
)