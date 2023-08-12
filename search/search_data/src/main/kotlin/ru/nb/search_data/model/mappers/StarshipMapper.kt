package ru.nb.search_data.model.mappers

import ru.nb.search_domain.model.Starship
import ru.nb.search_data.model.StarshipDto

fun StarshipDto.toStarship() = Starship(
	name = name,
	model = model,
	passengers = passengers,
	manufacturer = manufacturer
)