package ru.nb.favorite_domain.model

import ru.nb.search_domain.model.BaseUi

data class PeopleWithFilms(
	override val name: String,
	val gender: String,
	val starshipsCount: Int,
	val homeworld: String,
	val films: List<Film>,
	override val url: String
) : BaseUi(name = name, url = url)