package ru.nb.search_data.model.mappers

import ru.nb.search_data.model.FilmDto
import ru.nb.search_domain.model.Film

fun FilmDto.toFilm() = Film(
	title = title,
	director = director,
	producer = producer,
	url = url
)

fun Film.toFilmDto() = FilmDto(
	title = title,
	director = director,
	producer = producer,
	url = url
)