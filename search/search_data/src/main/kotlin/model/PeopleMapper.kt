package model

fun PeopleDto.toPeople() = People(
	name = name,
	gender = gender,
	homeworld = homeworld,
	starshipsCount = starships.size,
)