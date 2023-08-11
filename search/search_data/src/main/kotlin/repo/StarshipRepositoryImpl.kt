package repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.BaseResult
import model.BaseResultDto
import model.Starship
import model.StarshipDto
import model.mappers.toBaseResult
import model.mappers.toStarship

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