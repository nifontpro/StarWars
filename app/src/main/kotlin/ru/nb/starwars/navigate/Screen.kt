package ru.nb.starwars.navigate

sealed class Screen(val route: String) {

	object MainScreen : Screen("main_screen")

	// Bottom bar links
	object SearchScreen : Screen("search_screen")
	object FavoriteScreen : Screen("favorite_screen")
	object AboutScreen : Screen("about_screen")
}