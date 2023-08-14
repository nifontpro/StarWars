package ru.nb.search_data.model.mappers

import ru.nb.search_data.model.PeopleDto
import ru.nb.search_domain.model.People

fun PeopleDto.toPeople() = People(
	name = name,
	gender = gender,
	homeworld = homeworld,
	starshipsCount = starships.size,
	films = films,
	url = url,
)