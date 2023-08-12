package ru.nb.search_data.model.mappers

import ru.nb.search_domain.model.People
import ru.nb.search_data.model.PeopleDto

fun PeopleDto.toPeople() = People(
	name = name,
	gender = gender,
	homeworld = homeworld,
	starshipsCount = starships.size,
)