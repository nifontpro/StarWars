package ru.nb.search_data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResultDto<T>(
	@SerialName("count")
	val count: Int,
	@SerialName("next")
	val next: String?,
	@SerialName("previous")
	val previous: String?,
	@SerialName("results")
	val data: List<T>
)