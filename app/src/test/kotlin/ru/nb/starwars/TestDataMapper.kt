package ru.nb.starwars

import org.junit.Assert.*
import org.junit.Test
import ru.nb.search_data.model.PeopleDto
import ru.nb.search_data.model.mappers.toPeople

class TestDataMapper {

	@Test
	fun mapperTest() {
		val name = "Test name"
		val gender = "male"
		val homeworld = "Earth"
		val starships = listOf("1", "2", "3")
		val url = "test url"

		val peopleDto = PeopleDto(
			name = name,
			gender = gender,
			homeworld = homeworld,
			starships = starships,
			url = url,
			films = emptyList()
		)

		val people = peopleDto.toPeople()
		assertEquals(people.name, name)
		assertEquals(people.gender, gender)
		assertEquals(people.homeworld, homeworld)
		assertEquals(people.url, url)
		assertEquals(people.starshipsCount, starships.size)
	}

}