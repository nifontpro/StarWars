package ru.nb.search_data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PeopleDto(

	@SerialName("name")
	val name: String,

	@SerialName("gender")
	val gender: String,

	@SerialName("homeworld")
	val homeworld: String,

	@SerialName("starships")
	val starships: List<String>,

	@SerialName("films")
	val films: List<String>,

	@SerialName("url")
	val url: String,

)