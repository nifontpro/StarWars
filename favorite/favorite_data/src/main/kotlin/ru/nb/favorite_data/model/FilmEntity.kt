package ru.nb.favorite_data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FilmEntity(
	val title: String,
	val director: String,
	val producer: String,

	@PrimaryKey(autoGenerate = false)
	val filmUrl: String,
)