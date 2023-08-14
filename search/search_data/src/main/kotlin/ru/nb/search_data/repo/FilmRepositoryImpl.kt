package ru.nb.search_data.repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nb.search_data.model.FilmDto
import ru.nb.search_data.model.mappers.toFilm
import ru.nb.search_domain.model.Film
import ru.nb.search_domain.repo.FilmRepository

class FilmRepositoryImpl(private val httpClient: HttpClient) : FilmRepository {

	override suspend fun getByUrl(url: String): Film {
		return withContext(Dispatchers.IO) {
			val res: FilmDto = httpClient.get(url) {
			}.body()
			res.toFilm()
		}
	}

}