package ru.nb.search_data.repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nb.search_data.model.BaseResultDto
import ru.nb.search_data.model.PlanetDto
import ru.nb.search_data.model.mappers.toBaseResult
import ru.nb.search_data.model.mappers.toPlanet
import ru.nb.search_domain.model.BaseResult
import ru.nb.search_domain.model.Planet
import ru.nb.search_domain.repo.PlanetRepository

class PlanetRepositoryImpl(private val httpClient: HttpClient) : PlanetRepository {

	override suspend fun search(searchText: String): BaseResult<Planet> {
		return withContext(Dispatchers.IO) {
			val res: BaseResultDto<PlanetDto> = httpClient.get("https://swapi.dev/api/planets") {
				parameter("search", searchText)
			}.body()
			res.toBaseResult { it.toPlanet() }
		}
	}

}