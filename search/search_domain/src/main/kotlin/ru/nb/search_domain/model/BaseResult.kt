package ru.nb.search_domain.model

data class BaseResult<T>(
	val count: Int,
	val next: String?,
	val previous: String?,
	val data: List<T>
)