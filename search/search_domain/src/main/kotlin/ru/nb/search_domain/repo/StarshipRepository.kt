package ru.nb.search_domain.repo

import ru.nb.search_domain.model.BaseResult
import ru.nb.search_domain.model.Starship

interface StarshipRepository {
	suspend fun search(searchText: String): BaseResult<Starship>
}