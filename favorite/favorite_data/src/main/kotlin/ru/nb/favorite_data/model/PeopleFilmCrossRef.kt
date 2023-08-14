package ru.nb.favorite_data.model

import androidx.room.Entity

@Entity(primaryKeys = ["peopleUrl", "filmUrl"])
data class PeopleFilmCrossRef(
	val peopleUrl: String,
	val filmUrl: String
)
