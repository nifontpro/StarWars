package ru.nb.favorite_data.model.mappers

import ru.nb.favorite_data.model.PeopleEntity
import ru.nb.search_domain.model.People

fun People.toPeopleEntity() = PeopleEntity(
	name = name,
	gender = gender,
	starshipsCount = starshipsCount,
	homeworld = homeworld,
	url = url,
)

fun PeopleEntity.toPeople() = People(
	name = name,
	gender = gender,
	starshipsCount = starshipsCount,
	homeworld = homeworld,
	url = url
)