package ru.nb.search_domain.model


data class Planet(
	override val name: String,
	val diameter: String,
	val population: String,
	override val url: String
) : BaseUi(name = name, url = url)