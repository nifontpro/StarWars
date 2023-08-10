package ru.nb.starwars.navigate

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

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

		composable(
			"one",
//				arguments = listOf(navArgument(Argument.personId)),
		) {
			Text("Screen one")
		}

		composable(
			"two"
//				arguments = listOf(
//					navArgument(Argument.personId), navArgument(Argument.eventId)
//				),
		) {
			Text("Screen two")
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
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
		val bottomPadding = paddingValues.calculateBottomPadding()
		NavHost(
			navController = navController,
			startDestination = Screen.SearchScreen.route
		) {

			composable(Screen.SearchScreen.route) {
				Text("Search screen")
			}
			composable(Screen.FavoriteScreen.route) {
				Text("Favorite screen")
			}
			composable(Screen.AboutScreen.route) {
				Text("About screen")
			}
		}
	}
}