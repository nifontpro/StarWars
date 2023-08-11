package model.mappers

import model.BaseResult
import model.BaseResultDto

fun <T, R> BaseResultDto<T>.toBaseResult(transform: (T) -> R): BaseResult<R> = BaseResult(
	count = count,
	next = next,
	previous = previous,
	data = data.map(transform),
)