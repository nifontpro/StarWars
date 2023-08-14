package ru.nb.favorite_data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmDto(
	@SerialName("title")
	val title: String,

	@SerialName("director")
	val director: String,

	@SerialName("producer")
	val producer: String,

	@SerialName("url")
	val url: String,
)