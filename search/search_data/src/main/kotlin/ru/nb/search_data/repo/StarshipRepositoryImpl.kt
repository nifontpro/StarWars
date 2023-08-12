package ru.nb.search_data.repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nb.search_domain.model.BaseResult
import ru.nb.search_data.model.BaseResultDto
import ru.nb.search_domain.model.Starship
import ru.nb.search_data.model.StarshipDto
import ru.nb.search_data.model.mappers.toBaseResult
import ru.nb.search_data.model.mappers.toStarship
import ru.nb.search_domain.repo.StarshipRepository

class StarshipRepositoryImpl(private val httpClient: HttpClient) : StarshipRepository {

	override suspend fun search(searchText: String): BaseResult<Starship> {
		return withContext(Dispatchers.IO) {
			val res: BaseResultDto<StarshipDto> = httpClient.get("https://swapi.dev/api/starships") {
				parameter("search", searchText)
			}.body()
			res.toBaseResult { it.toStarship() }
		}
	}
}