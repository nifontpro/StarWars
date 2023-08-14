package ru.nb.favorite_data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PeopleEntity(
	val name: String,
	val gender: String,
	val starshipsCount: Int,
	val homeworld: String,

	@PrimaryKey(autoGenerate = false)
	val peopleUrl: String,
)
