package ru.nb.search_data.model.mappers

import ru.nb.search_data.model.PlanetDto
import ru.nb.search_domain.model.Planet

fun PlanetDto.toPlanet() = Planet(
	name = name,
	diameter = diameter,
	population = population,
	url = url
)