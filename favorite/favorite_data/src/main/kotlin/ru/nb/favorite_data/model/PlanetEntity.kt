package ru.nb.favorite_data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlanetEntity(
	val name: String,
	val diameter: String,
	val population: String,

	@PrimaryKey(autoGenerate = false)
	val url: String,
)