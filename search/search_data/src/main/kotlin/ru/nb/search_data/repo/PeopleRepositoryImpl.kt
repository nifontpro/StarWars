package ru.nb.search_data.repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nb.search_domain.model.BaseResult
import ru.nb.search_data.model.BaseResultDto
import ru.nb.search_domain.model.People
import ru.nb.search_data.model.PeopleDto
import ru.nb.search_data.model.mappers.toBaseResult
import ru.nb.search_data.model.mappers.toPeople
import ru.nb.search_domain.repo.PeopleRepository

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