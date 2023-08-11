package ru.nb.starwars.data.repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.nb.starwars.data.model.People
import ru.nb.starwars.data.model.Results

class PeopleRepositoryImpl(private val httpClient: HttpClient) {

	suspend fun getPeople(): Results<People> {
		return httpClient.get("https://swapi.dev/api/people") {
//			parameter("", "")
		}.body()
	}

}