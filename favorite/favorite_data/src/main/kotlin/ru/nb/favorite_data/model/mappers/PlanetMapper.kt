package ru.nb.favorite_data.model.mappers

import ru.nb.favorite_data.model.PlanetEntity
import ru.nb.search_domain.model.Planet

fun PlanetEntity.toPlanet() = Planet(
	name = name,
	diameter = diameter,
	population = population,
	url = url
)

fun Planet.toPlanetEntity() = PlanetEntity(
	name = name,
	diameter = diameter,
	population = population,
	url = url
)