package ru.nb.search_domain.model

data class People(
	override val name: String,
	val gender: String,
	val starshipsCount: Int,
	val homeworld: String,
): BaseUi(name = name, type = UiType.STARSHIP)