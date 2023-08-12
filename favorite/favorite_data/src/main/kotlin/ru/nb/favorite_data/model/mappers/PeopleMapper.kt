package ru.nb.favorite_data.model.mappers

import ru.nb.search_domain.model.People
import ru.nb.favorite_data.model.PeopleEntity

fun People.toPeopleEntity() = PeopleEntity(
	name = name,
	gender = gender,
	starshipsCount = starshipsCount,
	homeworld = homeworld
)

fun PeopleEntity.toPeople() = People(
	name = name,
	gender = gender,
	starshipsCount = starshipsCount,
	homeworld = homeworld
)