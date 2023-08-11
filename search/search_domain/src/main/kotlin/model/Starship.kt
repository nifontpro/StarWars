package model

data class Starship(
	override val name: String,
	val model: String,
	val passengers: String,
	val manufacturer: String,
) : BaseUi(name = name, type = UiType.STARSHIP)