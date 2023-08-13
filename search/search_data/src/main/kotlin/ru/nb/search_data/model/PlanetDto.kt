package ru.nb.search_data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetDto(
	@SerialName("name")
	val name: String,

	@SerialName("diameter")
	val diameter: String,

	@SerialName("population")
	val population: String,

	@SerialName("url")
	val url: String
)