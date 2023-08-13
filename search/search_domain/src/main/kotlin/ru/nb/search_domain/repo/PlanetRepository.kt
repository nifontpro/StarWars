package ru.nb.search_domain.repo

import ru.nb.search_domain.model.BaseResult
import ru.nb.search_domain.model.Planet

interface PlanetRepository {
	suspend fun search(searchText: String): BaseResult<Planet>
}