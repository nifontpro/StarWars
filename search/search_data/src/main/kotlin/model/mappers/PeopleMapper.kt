package model.mappers

import model.People
import model.PeopleDto

fun PeopleDto.toPeople() = People(
	name = name,
	gender = gender,
	homeworld = homeworld,
	starshipsCount = starships.size,
)