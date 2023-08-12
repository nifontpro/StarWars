package model.mappers

import model.People
import model.PeopleEntity

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