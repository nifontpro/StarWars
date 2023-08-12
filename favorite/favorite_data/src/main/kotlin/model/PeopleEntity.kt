package model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PeopleEntity(
	@PrimaryKey(autoGenerate = false)
	val name: String,

	val gender: String,
	val starshipsCount: Int,
	val homeworld: String,
)
