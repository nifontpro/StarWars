package repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.BaseResult
import model.BaseResultDto
import model.People
import model.PeopleDto
import model.mappers.toBaseResult
import model.mappers.toPeople

class PeopleRepositoryImpl(private val httpClient: HttpClient) : PeopleRepository {

	override suspend fun getPeople(): BaseResult<People> {
		val res: BaseResultDto<PeopleDto> = httpClient.get("https://swapi.dev/api/people") {
//			parameter("", "")
		}.body()
		return res.toBaseResult { it.toPeople() }
	}

	override suspend fun search(searchText: String): BaseResult<People> {
		return withContext(Dispatchers.IO) {
			val res: BaseResultDto<PeopleDto> = httpClient.get("https://swapi.dev/api/people") {
				parameter("search", searchText)
			}.body()
			res.toBaseResult { it.toPeople() }
		}
	}

	override suspend fun getNext(url: String): BaseResult<People> {
		return withContext(Dispatchers.IO) {
			val res: BaseResultDto<PeopleDto> = httpClient.get(url) {
			}.body()
			res.toBaseResult { it.toPeople() }
		}
	}

}