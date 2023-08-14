package ru.nb.favorite_data.model.mappers

import ru.nb.favorite_data.model.FilmDto
import ru.nb.favorite_data.model.FilmEntity
import ru.nb.favorite_domain.model.Film

fun FilmDto.toFilm() = Film(
	title = title,
	director = director,
	producer = producer,
	url = url
)

fun Film.toFilmEntity() = FilmEntity(
	title = title,
	director = director,
	producer = producer,
	filmUrl = url
)

fun FilmEntity.toFilm() = Film(
	title = title,
	director = director,
	producer = producer,
	url = filmUrl
)