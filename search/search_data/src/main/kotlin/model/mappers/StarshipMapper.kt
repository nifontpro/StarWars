package model.mappers

import model.Starship
import model.StarshipDto

fun StarshipDto.toStarship() = Starship(
	name = name,
	model = model,
	passengers = passengers,
	manufacturer = manufacturer
)