package ru.nb.search_domain.repo

import ru.nb.search_domain.model.Film

interface FilmRepository {
	suspend fun getByUrl(url: String): Film
}