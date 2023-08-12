package ru.nb.favorite_data.model.mappers

import ru.nb.favorite_data.model.StarshipEntity
import ru.nb.search_domain.model.Starship

fun Starship.toStarshipEntity() = StarshipEntity(
	name = name,
	model = model,
	passengers = passengers,
	manufacturer = manufacturer
)

fun StarshipEntity.toStarship() = Starship(
	name = name,
	model = model,
	passengers = passengers,
	manufacturer = manufacturer
)