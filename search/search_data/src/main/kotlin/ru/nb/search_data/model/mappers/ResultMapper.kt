package ru.nb.search_data.model.mappers

import ru.nb.search_domain.model.BaseResult
import ru.nb.search_data.model.BaseResultDto

fun <T, R> BaseResultDto<T>.toBaseResult(transform: (T) -> R): BaseResult<R> = BaseResult(
	count = count,
	next = next,
	previous = previous,
	data = data.map(transform),
)