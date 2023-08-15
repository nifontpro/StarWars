package ru.nb.starwars.navigate

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.nb.favorite_presenter.FavoriteScreen
import ru.nb.search_presenter.SearchScreen

@Composable
fun Navigate() {
	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = Screen.MainScreen.route
	) {
		composable(Screen.MainScreen.route) {
			ConfigureBottomNavigate()
		}
	}
}

@Composable
private fun ConfigureBottomNavigate() {
	val navController = rememberNavController()
	val backStackEntry = navController.currentBackStackEntryAsState()
	Scaffold(
		bottomBar = {
			BottomBar(
				onItemClick = { route ->
					navController.navigate(route) {
						navController.graph.startDestinationRoute?.let { route ->
							popUpTo(route) {
								saveState = true
							}
						}
						launchSingleTop = true
						restoreState = true
					}
				},
				isSelectItem = { route ->
					route == backStackEntry.value?.destination?.route
				}
			)
		}
	) { paddingValues ->
		NavHost(
			navController = navController,
			startDestination = Screen.SearchScreen.route
		) {

			composable(Screen.SearchScreen.route) {
				SearchScreen(paddingValues)
			}
			composable(Screen.FavoriteScreen.route) {
				FavoriteScreen(paddingValues)
			}
			composable(Screen.AboutScreen.route) {
				AboutScreen(paddingValues)
			}
		}
	}
}