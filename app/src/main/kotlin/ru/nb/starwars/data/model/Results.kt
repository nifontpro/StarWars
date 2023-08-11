package ru.nb.starwars.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Results<T>(
	@SerialName("count")
	val count: Int,
	@SerialName("next")
	val next: String?,
	@SerialName("previous")
	val previous: String?,
	@SerialName("results")
	val data: List<T>
)