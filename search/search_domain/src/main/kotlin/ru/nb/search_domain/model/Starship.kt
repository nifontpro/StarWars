package ru.nb.search_domain.model

data class Starship(
	override val name: String,
	val model: String,
	val passengers: String,
	val manufacturer: String,
	override val url: String
) : BaseUi(name = name, url = url)