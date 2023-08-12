package ru.nb.favorite_data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StarshipEntity(
	@PrimaryKey(autoGenerate = false)
	val name: String,

	val model: String,
	val passengers: String,
	val manufacturer: String,
)