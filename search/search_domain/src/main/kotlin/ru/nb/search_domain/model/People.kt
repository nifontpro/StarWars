package ru.nb.search_domain.model

data class People(
	override val name: String,
	val gender: String,
	val starshipsCount: Int,
	val homeworld: String,
	val films: List<String>,
	override val url: String
) : BaseUi(name = name, url = url)