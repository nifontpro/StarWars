package ru.nb.favorite_data.model.mappers

import ru.nb.favorite_data.model.PeopleEntity
import ru.nb.favorite_data.model.PeopleWithFilmsEntity
import ru.nb.favorite_domain.model.PeopleWithFilms
import ru.nb.search_domain.model.People

fun People.toPeopleEntity() = PeopleEntity(
	name = name,
	gender = gender,
	starshipsCount = starshipsCount,
	homeworld = homeworld,
	peopleUrl = url,
)

fun PeopleEntity.toPeople() = People(
	name = name,
	gender = gender,
	starshipsCount = starshipsCount,
	homeworld = homeworld,
	filmsUrls = emptyList(),
	url = peopleUrl
)

fun PeopleWithFilmsEntity.toPeopleWithFilms() = PeopleWithFilms(
	name = peopleEntity.name,
	gender = peopleEntity.gender,
	starshipsCount = peopleEntity.starshipsCount,
	homeworld = peopleEntity.homeworld,
	url = peopleEntity.peopleUrl,
	films = films.map { it.toFilm() }
)