package repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import model.BaseResult
import model.BaseResultDto
import model.People
import model.PeopleDto
import model.toBaseResult
import model.toPeople

class PeopleRepositoryImpl(private val httpClient: HttpClient) : PeopleRepository {

	override suspend fun getPeople(): BaseResult<People> {
		val res: BaseResultDto<PeopleDto> = httpClient.get("https://swapi.dev/api/people") {
//			parameter("", "")
		}.body()
		return res.toBaseResult { it.toPeople() }
	}

}